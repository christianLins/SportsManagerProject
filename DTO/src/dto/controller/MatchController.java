/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.controller;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Match;
import dto.contract.IMatch;
import dto.controller.contract.*;

/**

 @author Thomas
 */
 public class MatchController
        implements IController<IMatch>
{
    private static MatchController controller;

     MatchController()
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

    public domain.contract.IMatch getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IMatch a : DomainFacade.getAll(domain.contract.IMatch.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IMatch getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IMatch a : DomainFacade.getAll(domain.contract.IMatch.class))
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

        for (domain.contract.IMatch a : DomainFacade.getAll(domain.contract.IMatch.class))
        {
            result.add(Match.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IMatch value)
    {
        try
        {
            domain.classes.Match match = createDomain(value);

            return DomainFacade.set(match);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(MatchController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IMatch value)
    {
        try
        {
            domain.classes.Match match = createDomain(value);

            DomainFacade.delete(match);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Match createDomain(IMatch value)
            throws IdNotFoundException
    {
        domain.classes.Match match = new domain.classes.Match(value.getId());

        match.setCompetition(new CompetitionController().getDomainById(value.getCompetition()));
        match.setDateFrom(value.getDateFrom());
        match.setDateTo(value.getDateTo());

        match.setForeignteam(new TeamController().getDomainById(value.getForeignteam()));
        match.setHometeam(new TeamController().getDomainById(value.getHometeam()));
        match.setMatchresult(new MatchresultController().getDomainById(value.getMatchresult()));

        return match;
    }
}
