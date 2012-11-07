/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import java.util.logging.*;
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

    public ClubTeamController()
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
    public void set(IClubTeam value)
    {
        try
        {
            sportsclubmanager.domain.classes.ClubTeam clubTeam = new sportsclubmanager.domain.classes.ClubTeam();

            List<sportsclubmanager.domain.contract.IDepartment> departmentList = new LinkedList<>();
            for (int i : value.getDepartmentList())
            {
                departmentList.add(new DepartmentController().getDomainById(i));
            }

            List<sportsclubmanager.domain.contract.IPlayer> teamhasPlayerList = new LinkedList<>();
            for (int i : value.getPlayerList())
            {
                teamhasPlayerList.add(new PlayerController().getDomainById(i));
            }

            List<sportsclubmanager.domain.contract.ITrainer> trainerList = new LinkedList<>();
            for (int i : value.getTrainerList())
            {
                trainerList.add(new TrainerController().getDomainById(i));
            }

            clubTeam.setDepartmentList(departmentList);
            clubTeam.setPlayerList(teamhasPlayerList);
            clubTeam.setTrainerList(trainerList);

            DomainFacade.set(clubTeam);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
