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
public class MatchController
        implements IController<IMatch>
{
    private static MatchController controller;

    public MatchController()
    {
    }

    public static IController<IMatch> getInstance()
    {
        if (controller == null)
        {
            controller = new MatchController();
        }

        return controller;
    }

    public sportsclubmanager.domain.contract.IMatch getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IMatch a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMatch.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IMatch getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IMatch a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMatch.class))
        {
            if (a.getId() == id)
            {
                return Match.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IMatch> getAll()
    {
        List<IMatch> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IMatch a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMatch.class))
        {
            result.add(Match.copy(a));
        }

        return result;
    }

    @Override
    public void set(IMatch value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
