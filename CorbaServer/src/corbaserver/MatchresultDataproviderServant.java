/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaserver;

import corbaContract.generated.*;
import dto.contract.*;
import dto.mapper.DtoFactory;
import dto.mapper.contract.IdNotFoundException;
import java.rmi.RemoteException;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import org.omg.CORBA.ORB;

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

            ITypeOfSport t = DtoFactory.getTypeOfSportManager().getByName(typeOfSport);

            ILeague l = DtoFactory.getLeagueManager().getByName(league, t);

            Date date = DateFormat.getDateInstance().parse(competitiondate);

            for (ICompetition competition : l.getCompetitionList(date))
            {
                for (int matchId : competition.getMatchList())
                {
                    IMatch match = DtoFactory.getMatchManager().getById(matchId);
                    IMatchresult matchresult = match.getMatchresult();

                    results.add(new MatchresultCorba(matchresult.getId(), match.getDateFrom().toString(), match.getHometeam().getName(), match.getForeignteam().getName(), matchresult.getPointsHometeam(), matchresult.getPointsForeignteam()));
                }
            }

            return new MatchresultListCorba((MatchresultCorba[]) results.toArray());
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
            IMatchresult m = DtoFactory.getMatchresultManager().getById(matchresult.Id);

            return m.IsFinal();
        }
        catch (IdNotFoundException ex)
        {
            Logger.getLogger(MatchresultDataproviderServant.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex)
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
