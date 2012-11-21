/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import domain.*;
import dto.classes.Team;
import dto.contract.ITeam;
import dto.mapper.contract.*;
import java.util.*;
import java.util.logging.*;

/**

 @author Thomas
 */
public class TeamMapper
        implements IMapper<ITeam>
{
    private static TeamMapper controller;

    TeamMapper()
    {
    }

    public static IMapper<ITeam> getInstance()
    {
        if (controller == null)
        {
            controller = new TeamMapper();
        }

        return controller;
    }

    public domain.contract.ITeam getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.ITeam a = DomainFacade.getInstance().getByID(domain.contract.ITeam.class, id);
            return a;
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ITeam getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.ITeam a = DomainFacade.getInstance().getByID(domain.contract.ITeam.class, id);
            return Team.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ITeam> getAll()
            throws NotFoundException
    {
        try
        {
            List<ITeam> result = new LinkedList<>();

            for (domain.contract.ITeam a : DomainFacade.getInstance().getAll(domain.contract.ITeam.class))
            {
                result.add(Team.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ITeam value)
    {
        Integer rv = 0;
        try
        {
            domain.classes.Team team = createDomain(value);

            rv = DomainFacade.getInstance().set(team);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
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

    private domain.classes.Team createDomain(ITeam value)
            throws IdNotFoundException
    {
        domain.classes.Team team = new domain.classes.Team(value.getId());

        List<Integer> competitions = value.getCompetitionList();
        List<Integer> matches = value.getMatchList();

        team.setDescription(value.getDescription());
        team.setName(value.getName());
        team.setLeague(new LeagueMapper().getDomainById(value.getLeague()));

        LinkedList<domain.contract.ICompetition> c = new LinkedList<>();
        for (int id : competitions)
        {
            c.add(new CompetitionMapper().getDomainById(id));
        }
        team.setCompetitionList(c);

        LinkedList<domain.contract.IMatch> m = new LinkedList<>();
        for (int id : matches)
        {
            m.add(new MatchMapper().getDomainById(id));
        }
        team.setMatchList(m);
        return team;
    }

    @Override
    public ITeam getNew()
    {
        return new Team();
    }
}
