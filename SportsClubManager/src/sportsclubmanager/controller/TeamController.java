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
public class TeamController
        implements IController<ITeam>
{
    private static TeamController controller;

    private TeamController()
    {
    }

    public static IController<ITeam> getInstance()
    {
        if (controller == null)
        {
            controller = new TeamController();
        }

        return controller;
    }

    @Override
    public ITeam getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ITeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITeam.class))
        {
            if (a.getId() == id)
            {
                return Team.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<ITeam> getAll()
    {
        List<ITeam> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ITeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITeam.class))
        {
            result.add(Team.copy(a));
        }

        return result;
    }

    @Override
    public void set(ITeam value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
