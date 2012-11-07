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
public class TrainerController
        implements IController<ITrainer>
{
    private static TrainerController controller;

    public TrainerController()
    {
    }

    public static IController<ITrainer> getInstance()
    {
        if (controller == null)
        {
            controller = new TrainerController();
        }

        return controller;
    }

    public sportsclubmanager.domain.contract.ITrainer getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ITrainer a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITrainer.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public ITrainer getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ITrainer a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITrainer.class))
        {
            if (a.getId() == id)
            {
                return Trainer.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ITrainer> getAll()
    {
        List<ITrainer> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ITrainer a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITrainer.class))
        {
            result.add(Trainer.copy(a));
        }

        return result;
    }

    @Override
    public void set(ITrainer value)
    {
        try
        {
            sportsclubmanager.domain.classes.Trainer trainer = new sportsclubmanager.domain.classes.Trainer(value.getId());

            List<sportsclubmanager.domain.contract.IClubTeam> clubTeamList = new LinkedList<>();
            for (int i : value.getClubTeamList())
            {
                clubTeamList.add(new ClubTeamController().getDomainById(i));
            }
            trainer.setClubTeamList(clubTeamList);

            DomainFacade.set(trainer);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
