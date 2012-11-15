/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Match;
import dto.contract.IMatch;
import dto.mapper.contract.*;

/**
 *
 * @author Thomas
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

    public domain.contract.IMatch getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IMatch a = DomainFacade.getInstance().getByID(domain.contract.IMatch.class, id);
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
            domain.contract.IMatch a = DomainFacade.getInstance().getByID(domain.contract.IMatch.class, id);
            return Match.copy(a);

        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IMatch> getAll() throws NotFoundException
    {
        try
        {
            List<IMatch> result = new LinkedList<>();

            for (domain.contract.IMatch a : DomainFacade.getInstance().getAll(domain.contract.IMatch.class))
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
            domain.classes.Match match = createDomain(value);

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
            domain.classes.Match match = createDomain(value);

            DomainFacade.getInstance().delete(match);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MatchMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Match createDomain(IMatch value)
            throws IdNotFoundException
    {
        domain.classes.Match match = new domain.classes.Match(value.getId());

        match.setCompetition(new CompetitionMapper().getDomainById(value.getCompetition()));
        match.setDateFrom(value.getDateFrom());
        match.setDateTo(value.getDateTo());

        match.setForeignteam(new TeamMapper().getDomainById(value.getForeignteam().getId()));
        match.setHometeam(new TeamMapper().getDomainById(value.getHometeam().getId()));
        match.setMatchresult(new MatchresultMapper().getDomainById(value.getMatchresult().getId()));

        return match;
    }
}
