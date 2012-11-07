/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.ClubTeam;
import sportsclubmanager.dto.contract.IClubTeam;
import sportsclubmanager.dto.controller.contract.*;

/**

 @author Thomas
 */
class ClubTeamController
        implements IController<IClubTeam>
{
    private static ClubTeamController controller;

    ClubTeamController()
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

    public sportsclubmanager.domain.contract.IClubTeam getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IClubTeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.IClubTeam.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IClubTeam getById(Integer id)
            throws IdNotFoundException
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
    public Integer set(IClubTeam value)
    {
        try
        {
            sportsclubmanager.domain.classes.ClubTeam clubTeam = createDomain(value);

            return DomainFacade.set(clubTeam);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(ClubTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IClubTeam value)
    {
        try
        {
            sportsclubmanager.domain.classes.ClubTeam clubTeam = createDomain(value);

            DomainFacade.delete(clubTeam);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(ClubTeamController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private sportsclubmanager.domain.classes.ClubTeam createDomain(IClubTeam value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.ClubTeam clubTeam = new sportsclubmanager.domain.classes.ClubTeam(value.getId());
        List<sportsclubmanager.domain.contract.IDepartment> departmentList = new LinkedList<>();
        List<sportsclubmanager.domain.contract.IPlayer> teamhasPlayerList = new LinkedList<>();
        List<sportsclubmanager.domain.contract.ITrainer> trainerList = new LinkedList<>();

        for (int d : value.getDepartmentList())
        {
            departmentList.add(new DepartmentController().getDomainById(d));
        }

        for (int d : value.getPlayerList())
        {
            teamhasPlayerList.add(new PlayerController().getDomainById(d));
        }

        for (int d : value.getTrainerList())
        {
            trainerList.add(new TrainerController().getDomainById(d));
        }

        clubTeam.setDepartmentList(departmentList);
        clubTeam.setPlayerList(teamhasPlayerList);
        clubTeam.setTrainerList(trainerList);

        return clubTeam;
    }
}
