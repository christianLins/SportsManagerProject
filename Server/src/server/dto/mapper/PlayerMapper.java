package server.dto.mapper;

import contract.domain.*;
import contract.dto.IPlayer;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.dto.classes.Player;

/**

 @author Thomas
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

    public contract.domain.IPlayer getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPlayer a = DomainFacade.getInstance().getByID(contract.domain.IPlayer.class, id);
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
            contract.domain.IPlayer a = DomainFacade.getInstance().getByID(contract.domain.IPlayer.class, id);
            return Player.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IPlayer> getAll()
            throws NotFoundException
    {
        try
        {
            List<IPlayer> result = new LinkedList<>();

            for (contract.domain.IPlayer a : DomainFacade.getInstance().getAll(contract.domain.IPlayer.class))
            {
                result.add(Player.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IPlayer value)
    {
        Integer rv = 0;
        try
        {

            server.domain.classes.Player p = createDomain(value);
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

    private server.domain.classes.Player createDomain(IPlayer value)
            throws IdNotFoundException
    {
        server.domain.classes.Player player = new server.domain.classes.Player(value.getId());

        List<Integer> permissionList = value.getPermisssionList();
        List<Integer> typeOfSportList = value.getTypeOfSportList();

        LinkedList<contract.domain.IPermission> p = new LinkedList<>();
        for (int id : permissionList)
        {
            p.add(new PermissionMapper().getDomainById(id));
        }
        player.setPermissionList(p);

        LinkedList<contract.domain.ITypeOfSport> typeOfSports = new LinkedList<>();
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
            server.domain.classes.Player p = createDomain(value);
            DomainFacade.getInstance().delete(p);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PlayerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public IPlayer getNew()
    {
        return new Player();
    }
}
