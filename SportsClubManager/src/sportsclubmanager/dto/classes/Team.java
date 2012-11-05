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
    private static HashMap<ITeam, Team> teams = new HashMap<>();

    public static Team copy(ITeam team)
    {
        Team a;

        if (teams.containsKey(team))
        {
            a = teams.get(team);
        }
        else
        {
            a = new Team();

            a.setName(team.getName());
            a.setDescription(team.getDescription());
            a.setLeague(team.getLeague());
            a.setCompetitionList(team.getCompetitionList());
            a.setLeague(team.getLeague());
            a.setMatchList(team.getMatchList());

            teams.put(team, a);
        }

        return a;
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

    @Override
    public List<ICompetition> getCompetitionList()
    {
        List<ICompetition> result = new LinkedList<>();

        for (Competition c : competitionList)
        {
            result.add(c);
        }

        return result;
    }

    @Override
    public void setCompetitionList(List<ICompetition> competitionList)
    {
        List<Competition> result = new LinkedList<>();

        for (ICompetition c : competitionList)
        {
            result.add(Competition.copy(c));
        }

        this.competitionList = result;
    }

    @Override
    public List<IMatch> getMatchList()
    {
        List<IMatch> result = new LinkedList<>();

        for (IMatch c : matchList)
        {
            result.add(Match.copy(c));
        }

        return result;
    }

    @Override
    public void setMatchList(List<IMatch> matchList)
    {
        List<Match> result = new LinkedList<>();

        for (IMatch c : matchList)
        {
            result.add(Match.copy(c));
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
        this.league = League.copy(league);
    }
}
