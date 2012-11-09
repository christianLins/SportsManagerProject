/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import domain.CouldNotSaveException;
import domain.DomainFacade;
import dto.classes.Team;
import dto.contract.ITeam;
import dto.mapper.contract.IMapper;
import dto.mapper.contract.IdNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        for (domain.contract.ITeam a : DomainFacade.getAll(domain.contract.ITeam.class))
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
        for (domain.contract.ITeam a : DomainFacade.getAll(domain.contract.ITeam.class))
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

        for (domain.contract.ITeam a : DomainFacade.getAll(domain.contract.ITeam.class))
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
            domain.classes.Team team = createDomain(value);

            rv = DomainFacade.set(team);
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
        
        LinkedList<domain.contract.ICompetition>  c = new LinkedList<>();
        for(int id:competitions)
        {
            c.add(new CompetitionMapper().getDomainById(id));
        }
        team.setCompetitionList(c);
        
        LinkedList<domain.contract.IMatch> m = new LinkedList<>();
        for(int id:matches)
        {
            m.add(new MatchMapper().getDomainById(id));
        }
        team.setMatchList(m);
        return team;
    }
}
