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
public class LeagueController
        implements IController<ILeague>
{
    private static LeagueController controller;

    private LeagueController()
    {
    }

    public static IController<ILeague> getInstance()
    {
        if (controller == null)
        {
            controller = new LeagueController();
        }

        return controller;
    }

    @Override
    public ILeague getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ILeague a : DomainFacade.getAll(sportsclubmanager.domain.contract.ILeague.class))
        {
            if (a.getId() == id)
            {
                return League.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<ILeague> getAll()
    {
        List<ILeague> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ILeague a : DomainFacade.getAll(sportsclubmanager.domain.contract.ILeague.class))
        {
            result.add(League.copy(a));
        }

        return result;
    }

    @Override
    public void set(ILeague value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
