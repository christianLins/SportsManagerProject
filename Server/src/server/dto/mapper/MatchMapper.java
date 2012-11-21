/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IMatch;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.dto.classes.Match;

/**

 @author Thomas
 */
public class MatchMapper
        implements IMapper<IMatch>
{
    private static MatchMapper controller;

    MatchMapper()
    {
    }

    public static IMapper<IMatch> getInstance()
    {
        if (controller == null)
        {
            controller = new MatchMapper();
        }

        return controller;
    }

    public contract.domain.IMatch getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IMatch a = DomainFacade.getInstance().getByID(contract.domain.IMatch.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IMatch getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IMatch a = DomainFacade.getInstance().getByID(contract.domain.IMatch.class, id);
            return Match.copy(a);

        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IMatch> getAll()
            throws NotFoundException
    {
        try
        {
            List<IMatch> result = new LinkedList<>();

            for (contract.domain.IMatch a : DomainFacade.getInstance().getAll(contract.domain.IMatch.class))
            {
                result.add(Match.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IMatch value)
    {
        try
        {
            server.domain.classes.Match match = createDomain(value);

            return DomainFacade.getInstance().set(match);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(MatchMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IMatch value)
    {
        try
        {
            server.domain.classes.Match match = createDomain(value);

            DomainFacade.getInstance().delete(match);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MatchMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Match createDomain(IMatch value)
            throws IdNotFoundException
    {
        server.domain.classes.Match match = new server.domain.classes.Match(value.getId());

        match.setCompetition(new CompetitionMapper().getDomainById(value.getCompetition()));
        match.setDateFrom(value.getDateFrom());
        match.setDateTo(value.getDateTo());

        match.setForeignteam(new TeamMapper().getDomainById(value.getForeignteam().getId()));
        match.setHometeam(new TeamMapper().getDomainById(value.getHometeam().getId()));
        match.setMatchresult(new MatchresultMapper().getDomainById(value.getMatchresult().getId()));

        return match;
    }

    @Override
    public IMatch getNew()
    {
        return new Match();
    }
}
