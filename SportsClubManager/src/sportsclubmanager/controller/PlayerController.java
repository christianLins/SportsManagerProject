/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import sportsclubmanager.controller.contract.IdNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.*;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class PlayerController
        implements IController<IPlayer>
{
    private static PlayerController controller;

    public PlayerController()
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

    public sportsclubmanager.domain.contract.IPlayer getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IPlayer a : DomainFacade.getAll(sportsclubmanager.domain.contract.IPlayer.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IPlayer getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IPlayer a : DomainFacade.getAll(sportsclubmanager.domain.contract.IPlayer.class))
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

        for (sportsclubmanager.domain.contract.IPlayer a : DomainFacade.getAll(sportsclubmanager.domain.contract.IPlayer.class))
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
            
            sportsclubmanager.domain.classes.Player p = createDomain(value);
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
    
    private sportsclubmanager.domain.classes.Player createDomain(IPlayer value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Player player = new sportsclubmanager.domain.classes.Player(value.getId());
        
        List<Integer> permissionList = value.getPermisssionList();
        List<Integer> typeOfSportList = value.getTypeOfSportList();
        
        LinkedList<sportsclubmanager.domain.contract.IPermission> p = new LinkedList<>();
        for(int id : permissionList)
        {
            p.add(new PermissionController().getDomainById(id));
        }
        player.setPermisssionList(p);
        
        LinkedList<sportsclubmanager.domain.contract.ITypeOfSport> typeOfSports = new LinkedList<>();
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
            sportsclubmanager.domain.classes.Player p = createDomain(value);
            DomainFacade.delete(p);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
