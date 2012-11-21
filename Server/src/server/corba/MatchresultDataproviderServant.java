/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.corba;

import contract.dto.mapper.IdNotFoundException;
import contract.dto.mapper.NotFoundException;
import contract.dto.ITypeOfSport;
import contract.dto.ILeague;
import contract.dto.IMatch;
import contract.dto.ICompetition;
import contract.dto.IMatchresult;
import java.rmi.RemoteException;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import org.omg.CORBA.ORB;
import server.corba.generated.*;
import server.dto.mapper.DtoFactory;

/**

 @author Thomas
 */
public class MatchresultDataproviderServant
        extends MatchresultDataproviderPOA
{
    private ORB orb;

    public void setORB(ORB orb_val)
    {
        orb = orb_val;
    }

    @Override
    public MatchresultListCorba getMatchresults(String typeOfSport, String league, String competitiondate)
    {
        try
        {
            List<MatchresultCorba> results = new LinkedList<>();

            ITypeOfSport t = DtoFactory.getTypeOfSportMapper().getByName(typeOfSport);

            ILeague l = DtoFactory.getLeagueMapper().getByName(league, t);

            Date date = DateFormat.getDateInstance().parse(competitiondate);

            for (ICompetition competition : l.getCompetitionList(date))
            {
                for (int matchId : competition.getMatchList())
                {
                    IMatch match = DtoFactory.getMatchMapper().getById(matchId);
                    IMatchresult matchresult = match.getMatchresult();

                    results.add(new MatchresultCorba(matchresult.getId(), match.getDateFrom().toString(), match.getHometeam().getName(), match.getForeignteam().getName(), matchresult.getPointsHometeam(), matchresult.getPointsForeignteam()));
                }
            }

            return new MatchresultListCorba((MatchresultCorba[]) results.toArray());
        }
        catch (NotFoundException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean isMatchresultFinal(MatchresultCorba matchresult)
    {
        try
        {
            IMatchresult m = DtoFactory.getMatchresultMapper().getById(matchresult.Id);

            return m.IsFinal();
        }
        catch (IdNotFoundException | RemoteException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void shutdown()
    {
        orb.shutdown(false);
    }
}
