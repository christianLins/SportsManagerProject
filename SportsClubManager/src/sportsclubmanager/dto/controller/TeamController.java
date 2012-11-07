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
    public Integer set(ITeam value)
    {
        Integer rv = 0;
        try
        {
            sportsclubmanager.domain.classes.Team team = createDomain(value);

            rv = DomainFacade.set(team);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return rv;
        }
    }

    @Override
    public void delete(ITeam value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private sportsclubmanager.domain.classes.Team createDomain(ITeam value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Team team = new sportsclubmanager.domain.classes.Team(value.getId());
        
        List<Integer> competitions = value.getCompetitionList();
        List<Integer> matches = value.getMatchList();
        
        team.setDescription(value.getDescription());
        team.setName(value.getName());
        team.setLeague(new LeagueController().getDomainById(value.getLeague()));
        
        LinkedList<sportsclubmanager.domain.contract.ICompetition>  c = new LinkedList<>();
        for(int id:competitions)
        {
            c.add(new CompetitionController().getDomainById(id));
        }
        team.setCompetitionList(c);
        
        LinkedList<sportsclubmanager.domain.contract.IMatch> m = new LinkedList<>();
        for(int id:matches)
        {
            m.add(new MatchController().getDomainById(id));
        }
        team.setMatchList(m);
        return team;
    }
}
