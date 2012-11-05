package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Match
        implements Serializable, IMatch
{
    private Date dateFrom;
    private Date dateTo;
    private Competition competition;
    private Matchresult matchresult;
    private Team foreignteam;
    private Team hometeam;

    public Match()
    {
    }
    private static HashMap<IMatch, Match> matchs = new HashMap<>();

    public static Match copy(IMatch match)
    {
        Match a;

        if (matchs.containsKey(match))
        {
            a = matchs.get(match);
        }
        else
        {
            a = new Match();

            a.setDateFrom(match.getDateFrom());
            a.setDateTo(match.getDateTo());
            a.setCompetition(match.getCompetition());
            a.setMatchresult(match.getMatchresult());
            a.setForeignteam(match.getForeignteam());
            a.setHometeam(match.getHometeam());

            matchs.put(match, a);
        }

        return a;
    }

    @Override
    public Date getDateFrom()
    {
        return dateFrom;
    }

    @Override
    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    @Override
    public Date getDateTo()
    {
        return dateTo;
    }

    @Override
    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    @Override
    public ICompetition getCompetition()
    {
        return competition;
    }

    @Override
    public void setCompetition(ICompetition competition)
    {
        this.competition = Competition.copy(competition);
    }

    @Override
    public IMatchresult getMatchresult()
    {
        return matchresult;
    }

    @Override
    public void setMatchresult(IMatchresult matchresult)
    {
        this.matchresult = Matchresult.copy(matchresult);
    }

    @Override
    public ITeam getForeignteam()
    {
        return foreignteam;
    }

    @Override
    public void setForeignteam(ITeam foreignteam)
    {
        this.foreignteam = Team.copy(foreignteam);
    }

    @Override
    public ITeam getHometeam()
    {
        return hometeam;
    }

    @Override
    public void setHometeam(ITeam hometeam)
    {
        this.hometeam = Team.copy(hometeam);
    }
}
