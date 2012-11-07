/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.controller;

import dto.controller.contract.IdNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import dto.controller.contract.IController;
import domain.*;
import dto.classes.*;
import dto.contract.*;

/**

 @author Thomas
 */
 public class PlayerController
        implements IController<IPlayer>
{
    private static PlayerController controller;

     PlayerController()
    {
    }

    public static IController<IPlayer> getInstance()
    {
        if (controller == null)
        {
            controller = new PlayerController();
        }

        return controller;
    }

    public domain.contract.IPlayer getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IPlayer a : DomainFacade.getAll(domain.contract.IPlayer.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IPlayer getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IPlayer a : DomainFacade.getAll(domain.contract.IPlayer.class))
        {
            if (a.getId() == id)
            {
                return Player.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IPlayer> getAll()
    {
        List<IPlayer> result = new LinkedList<>();

        for (domain.contract.IPlayer a : DomainFacade.getAll(domain.contract.IPlayer.class))
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
            rv = DomainFacade.set(p);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return  rv;
        }
    }
    
    private domain.classes.Player createDomain(IPlayer value)
            throws IdNotFoundException
    {
        domain.classes.Player player = new domain.classes.Player(value.getId());
        
        List<Integer> permissionList = value.getPermisssionList();
        List<Integer> typeOfSportList = value.getTypeOfSportList();
        
        LinkedList<domain.contract.IPermission> p = new LinkedList<>();
        for(int id : permissionList)
        {
            p.add(new PermissionController().getDomainById(id));
        }
        player.setPermisssionList(p);
        
        LinkedList<domain.contract.ITypeOfSport> typeOfSports = new LinkedList<>();
        for(int id : typeOfSportList)
        {
            typeOfSports.add(new TypeOfSportController().getDomainById(id));
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
            DomainFacade.delete(p);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
