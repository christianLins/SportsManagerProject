/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.controller;

import dto.controller.contract.IdNotFoundException;
import java.util.*;
import java.util.logging.*;
import dto.controller.contract.IController;
import domain.*;
import dto.classes.*;
import dto.contract.*;

/**

 @author Thomas
 */
public class LeagueController
        implements IController<ILeague>
{
    private static LeagueController controller;

     LeagueController()
    {
    }

    public static IController<ILeague> getInstance()
    {
        if (controller == null)
        {
            controller = new LeagueController();
        }

        return controller;
    }

    public domain.contract.ILeague getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.ILeague a : DomainFacade.getAll(domain.contract.ILeague.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public ILeague getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.ILeague a : DomainFacade.getAll(domain.contract.ILeague.class))
        {
            if (a.getId() == id)
            {
                return League.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ILeague> getAll()
    {
        List<ILeague> result = new LinkedList<>();

        for (domain.contract.ILeague a : DomainFacade.getAll(domain.contract.ILeague.class))
        {
            result.add(League.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(ILeague value)
    {
        try
        {
            domain.classes.League league = createDomain(value);

            return DomainFacade.set(league);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ILeague value)
    {
        try
        {
            domain.classes.League league = createDomain(value);

            DomainFacade.delete(league);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.League createDomain(ILeague value)
            throws IdNotFoundException
    {
        domain.classes.League league = new domain.classes.League(value.getId());

        league.setDescription(value.getDescription());
        league.setName(value.getName());

        List<domain.contract.ITeam> teamList = new LinkedList<>();

        for (int i : value.getTeamList())
        {
            teamList.add(new TeamController().getDomainById(i));
        }

        league.setTeamList(teamList);

        return league;
    }
}
