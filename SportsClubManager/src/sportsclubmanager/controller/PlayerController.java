/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
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

    private PlayerController()
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

    @Override
    public IPlayer getById(Integer id) throws IdNotFoundException
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
    public void set(IPlayer value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
