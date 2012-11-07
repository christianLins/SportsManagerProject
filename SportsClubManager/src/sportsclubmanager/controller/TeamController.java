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
public class TeamController
        implements IController<ITeam>
{
    private static TeamController controller;

    public TeamController()
    {
    }

    public static IController<ITeam> getInstance()
    {
        if (controller == null)
        {
            controller = new TeamController();
        }

        return controller;
    }

    public sportsclubmanager.domain.contract.ITeam getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ITeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITeam.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public ITeam getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ITeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITeam.class))
        {
            if (a.getId() == id)
            {
                return Team.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ITeam> getAll()
    {
        List<ITeam> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ITeam a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITeam.class))
        {
            result.add(Team.copy(a));
        }

        return result;
    }

    @Override
    public void set(ITeam value)
    {
        try
        {
            sportsclubmanager.domain.classes.Team team = new sportsclubmanager.domain.classes.Team();

            List<sportsclubmanager.domain.contract.ICompetition> competitionList = new LinkedList<>();
            for (int i : value.getCompetitionList())
            {
                competitionList.add(new CompetitionController().getDomainById(i));
            }
            team.setCompetitionList(competitionList);

            team.setDescription(value.getDescription());

            team.setLeague(new LeagueController().getDomainById(value.getLeague()));

            List<sportsclubmanager.domain.contract.IMatch> matchList = new LinkedList<>();
            for (int i : value.getMatchList())
            {
                matchList.add(new MatchController().getDomainById(i));
            }
            team.setMatchList(matchList);

            team.setName(value.getName());

            DomainFacade.set(team);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
