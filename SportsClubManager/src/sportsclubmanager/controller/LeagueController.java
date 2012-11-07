/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import sportsclubmanager.controller.contract.IdNotFoundException;
import java.util.*;
import java.util.logging.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.*;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class LeagueController
        implements IController<ILeague>
{
    private static LeagueController controller;

    public LeagueController()
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

    public sportsclubmanager.domain.contract.ILeague getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ILeague a : DomainFacade.getAll(sportsclubmanager.domain.contract.ILeague.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public ILeague getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ILeague a : DomainFacade.getAll(sportsclubmanager.domain.contract.ILeague.class))
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

        for (sportsclubmanager.domain.contract.ILeague a : DomainFacade.getAll(sportsclubmanager.domain.contract.ILeague.class))
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
            sportsclubmanager.domain.classes.League league = createDomain(value);

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
            sportsclubmanager.domain.classes.League league = createDomain(value);

            DomainFacade.delete(league);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(LeagueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private sportsclubmanager.domain.classes.League createDomain(ILeague value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.League league = new sportsclubmanager.domain.classes.League(value.getId());

        league.setDescription(value.getDescription());
        league.setName(value.getName());

        List<sportsclubmanager.domain.contract.ITeam> teamList = new LinkedList<>();

        for (int i : value.getTeamList())
        {
            teamList.add(new TeamController().getDomainById(i));
        }

        league.setTeamList(teamList);

        return league;
    }
}
