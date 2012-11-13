/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import dto.mapper.contract.IdNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.mapper.contract.IMapper;
import domain.*;
import dto.classes.*;
import dto.contract.*;

/**
 *
 * @author Thomas
 */
public class PlayerMapper
        implements IMapper<IPlayer>
{
    private static PlayerMapper controller;

    PlayerMapper()
    {
    }

    public static IMapper<IPlayer> getInstance()
    {
        if (controller == null)
        {
            controller = new PlayerMapper();
        }

        return controller;
    }

    public domain.contract.IPlayer getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IPlayer a = DomainFacade.getInstance().getByID(domain.contract.IPlayer.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IPlayer getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IPlayer a = DomainFacade.getInstance().getByID(domain.contract.IPlayer.class, id);
            return Player.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IPlayer> getAll()
    {
        List<IPlayer> result = new LinkedList<>();

        for (domain.contract.IPlayer a : DomainFacade.getInstance().getAll(domain.contract.IPlayer.class))
        {
            result.add(Player.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IPlayer value)
    {
        Integer rv = 0;
        try
        {

            domain.classes.Player p = createDomain(value);
            rv = DomainFacade.getInstance().set(p);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(PlayerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return rv;
        }
    }

    private domain.classes.Player createDomain(IPlayer value)
            throws IdNotFoundException
    {
        domain.classes.Player player = new domain.classes.Player(value.getId());

        List<Integer> permissionList = value.getPermisssionList();
        List<Integer> typeOfSportList = value.getTypeOfSportList();

        LinkedList<domain.contract.IPermission> p = new LinkedList<>();
        for (int id : permissionList)
        {
            p.add(new PermissionMapper().getDomainById(id));
        }
        player.setPermisssionList(p);

        LinkedList<domain.contract.ITypeOfSport> typeOfSports = new LinkedList<>();
        for (int id : typeOfSportList)
        {
            typeOfSports.add(new TypeOfSportMapper().getDomainById(id));
        }
        player.setTypeOfSportList(typeOfSports);

        return player;
    }

    @Override
    public void delete(IPlayer value)
    {
        try
        {
            domain.classes.Player p = createDomain(value);
            DomainFacade.getInstance().delete(p);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PlayerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
