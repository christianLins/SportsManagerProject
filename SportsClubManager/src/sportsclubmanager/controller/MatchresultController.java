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
public class MatchresultController
        implements IController<IMatchresult>
{
    private static MatchresultController controller;

    public MatchresultController()
    {
    }

    public static IController<IMatchresult> getInstance()
    {
        if (controller == null)
        {
            controller = new MatchresultController();
        }

        return controller;
    }

        @Override
    public sportsclubmanager.domain.contract.IMatchresult getById(Integer id) throws IdNotFoundException
    {
    for (sportsclubmanager.domain.contract.IMatchresult a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMatchresult.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }
        
        throw new IdNotFoundException();
    }
        
    @Override
    public IMatchresult getById(Integer id) throws IdNotFoundException
    {
    for (sportsclubmanager.domain.contract.IMatchresult a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMatchresult.class))
        {
            if (a.getId() == id)
            {
                return Matchresult.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IMatchresult> getAll()
    {
             List<IMatchresult> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IMatchresult a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMatchresult.class))
        {
            result.add(Matchresult.copy(a));
        }

        return result;
    }

    @Override
    public void set(IMatchresult value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
