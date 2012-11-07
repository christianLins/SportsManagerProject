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
public class TrainerController
        implements IController<ITrainer>
{
    private static TrainerController controller;

    private TrainerController()
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

    @Override
    public ITrainer getById(Integer id)throws IdNotFoundException
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
