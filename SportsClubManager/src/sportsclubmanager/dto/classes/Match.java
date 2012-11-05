package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.dto.contract.IMatch;

public class Match
        implements Serializable, IMatch
{
    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Integer competition;
    private Integer matchresult;
    private Integer foreignteam;
    private Integer hometeam;

    public Match()
    {
    }

    public Match(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<sportsclubmanager.domain.contract.IMatch, Match> matchs = new HashMap<>();

    public static Match copy(sportsclubmanager.domain.contract.IMatch match)
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
            a.competition = match.getCompetition().getId();
            a.matchresult = match.getMatchresult().getId();
            a.foreignteam = match.getForeignteam().getId();
            a.hometeam = match.getHometeam().getId();

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
    public Integer getCompetition()
    {
        return competition;
    }

    @Override
    public void setCompetition(Integer competition)
    {
        this.competition = competition;
    }

    @Override
    public Integer getMatchresult()
    {
        return matchresult;
    }

    @Override
    public void setMatchresult(Integer matchresult)
    {
        this.matchresult = matchresult;
    }

    @Override
    public Integer getForeignteam()
    {
        return foreignteam;
    }

    @Override
    public void setForeignteam(Integer foreignteam)
    {
        this.foreignteam = foreignteam;
    }

    @Override
    public Integer getHometeam()
    {
        return hometeam;
    }

    @Override
    public void setHometeam(Integer hometeam)
    {
        this.hometeam = hometeam;
    }
}
