/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Matchresult;
import dto.contract.IMatchresult;
import dto.mapper.contract.*;

/**

 @author Thomas
 */
 public class MatchresultMapper
        implements IMapper<IMatchresult>
{
    private static MatchresultMapper controller;

     MatchresultMapper()
    {
    }

    public static IMapper<IMatchresult> getInstance()
    {
        if (controller == null)
        {
            controller = new MatchresultMapper();
        }

        return controller;
    }

    public domain.contract.IMatchresult getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IMatchresult a : DomainFacade.getAll(domain.contract.IMatchresult.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public IMatchresult getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IMatchresult a : DomainFacade.getAll(domain.contract.IMatchresult.class))
        {
            if (a.getId() == id)
            {
                return Matchresult.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<IMatchresult> getAll()
    {
        List<IMatchresult> result = new LinkedList<>();

        for (domain.contract.IMatchresult a : DomainFacade.getAll(domain.contract.IMatchresult.class))
        {
            result.add(Matchresult.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IMatchresult value)
    {
        try
        {
            domain.classes.Matchresult matchresult = createDomain(value);

            return DomainFacade.set(matchresult);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(MatchresultMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IMatchresult value)
    {
        try
        {
            domain.classes.Matchresult matchresult = createDomain(value);

            DomainFacade.delete(matchresult);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MatchresultMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Matchresult createDomain(IMatchresult value)
            throws IdNotFoundException
    {
        domain.classes.Matchresult matchresult = new domain.classes.Matchresult(value.getId());

        matchresult.setPointsForeignteam(value.getPointsForeignteam());
        matchresult.setPointsHometeam(value.getPointsHometeam());

        return matchresult;
    }
}
