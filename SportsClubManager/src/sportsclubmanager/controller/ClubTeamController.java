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
public class ClubTeamController
        implements IController<IClubTeam>
{
    private static ClubTeamController controller;

    private ClubTeamController()
    {
    }

    public static IController<IClubTeam> getInstance()
    {
        if (controller == null)
        {
            controller = new ClubTeamController();
        }

        return controller;
    }

    @Override
    public IClubTeam getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IClubTeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.IClubTeam.class))
        {
            if (a.getId() == id)
            {
                return ClubTeam.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IClubTeam> getAll()
    {
        List<IClubTeam> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IClubTeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.IClubTeam.class))
        {
            result.add(ClubTeam.copy(a));
        }

        return result;
    }

    @Override
    public void set(IClubTeam value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
