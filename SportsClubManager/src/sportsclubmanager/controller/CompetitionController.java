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

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class CompetitionController
        implements IController<ICompetition>
{
    private static CompetitionController controller;

    private CompetitionController()
    {
    }

    public static IController<ICompetition> getInstance()
    {
        if (controller == null)
        {
            controller = new CompetitionController();
        }

        return controller;
    }

    @Override
    public ICompetition getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ICompetition a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICompetition.class))
        {
            if (a.getId() == id)
            {
                return Competition.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<ICompetition> getAll()
    {
        List<ICompetition> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ICompetition a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICompetition.class))
        {
            result.add(Competition.copy(a));
        }

        return result;
    }

    @Override
    public void set(ICompetition value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
