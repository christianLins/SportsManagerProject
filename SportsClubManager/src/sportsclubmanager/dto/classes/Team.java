package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Team
        implements Serializable, ITeam
{
    private String name;
    private String description;
    private List<Competition> competitionList = new LinkedList<>();
    private List<Match> matchList = new LinkedList<>();
    private League league;

    public Team()
    {
    }

    public Team(ITeam c)
    {
        name = c.getName();
        description = c.getDescription();

        for (ICompetition competition : c.getCompetitionList())
        {
            competitionList.add(new Competition(competition));
        }

        for (IMatch match : c.getMatchList())
        {
            matchList.add(new Match(match));
        }

        league = new League(c.getLeague());
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<ICompetition> getCompetitionList()
    {
        List<ICompetition> result = new LinkedList<>();

        for (Competition c : competitionList)
        {
            result.add(c);
        }

        return result;
    }

    public void setCompetitionList(List<ICompetition> competitionList)
    {
        List<Competition> result = new LinkedList<>();

        for (ICompetition c : competitionList)
        {
            result.add(new Competition(c));
        }

        this.competitionList = result;
    }

    @Override
    public List<IMatch> getMatchList()
    {
        List<IMatch> result = new LinkedList<>();

        for (IMatch c : matchList)
        {
            result.add(new Match(c));
        }

        return result;
    }

    @Override
    public void setMatchList(List<IMatch> matchList)
    {
        List<Match> result = new LinkedList<>();

        for (IMatch c : matchList)
        {
            result.add(new Match(c));
        }

        this.matchList = result;
    }

    @Override
    public ILeague getLeague()
    {
        return league;
    }

    @Override
    public void setLeague(ILeague league)
    {
        this.league = new League(league);
    }
}
