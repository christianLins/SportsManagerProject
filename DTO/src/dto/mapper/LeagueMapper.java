/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import dto.mapper.contract.IdNotFoundException;
import java.util.*;
import java.util.logging.*;
import dto.mapper.contract.IMapper;
import domain.*;
import dto.classes.*;
import dto.contract.*;

/**
 *
 * @author Thomas
 */
public class LeagueMapper
        implements IMapper<ILeague>
{
    private static LeagueMapper controller;

    LeagueMapper()
    {
    }

    public static IMapper<ILeague> getInstance()
    {
        if (controller == null)
        {
            controller = new LeagueMapper();
        }

        return controller;
    }

    public domain.contract.ILeague getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.ILeague a = DomainFacade.getInstance().getByID(domain.contract.ILeague.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public ILeague getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.ILeague a = DomainFacade.getInstance().getByID(domain.contract.ILeague.class, id);
            return League.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ILeague> getAll()
    {
        List<ILeague> result = new LinkedList<>();

        for (domain.contract.ILeague a : DomainFacade.getInstance().getAll(domain.contract.ILeague.class))
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

            return DomainFacade.getInstance().set(league);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(LeagueMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ILeague value)
    {
        try
        {
            domain.classes.League league = createDomain(value);

            DomainFacade.getInstance().delete(league);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(LeagueMapper.class.getName()).log(Level.SEVERE, null, ex);
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
            teamList.add(new TeamMapper().getDomainById(i));
        }

        league.setTeamList(teamList);

        return league;
    }
}
