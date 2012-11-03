package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.Date;
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

    Match(IMatch c)
    {
        dateFrom = c.getDateFrom();
        dateTo = c.getDateTo();
        competition = new Competition(c.getCompetition());
        matchresult = new Matchresult(c.getMatchresult());
        foreignteam = new Team(c.getForeignteam());
        hometeam = new Team(c.getHometeam());
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
        this.competition = new Competition(competition);
    }

    @Override
    public IMatchresult getMatchresult()
    {
        return matchresult;
    }

    @Override
    public void setMatchresult(IMatchresult matchresult)
    {
        this.matchresult = new Matchresult(matchresult);
    }

    @Override
    public ITeam getForeignteam()
    {
        return foreignteam;
    }

    @Override
    public void setForeignteam(ITeam foreignteam)
    {
        this.foreignteam = new Team(foreignteam);
    }

    @Override
    public ITeam getHometeam()
    {
        return hometeam;
    }

    @Override
    public void setHometeam(ITeam hometeam)
    {
        this.hometeam = new Team(hometeam);
    }
}
