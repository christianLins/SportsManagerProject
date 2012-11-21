package server.dto.classes;

import java.io.Serializable;
import java.util.*;
import contract.dto.ITeam;

public class Team
        implements Serializable, ITeam
{
    private int id;
    private String name;
    private String description;
    private List<Integer> competitionList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();
    private Integer league;
    private static HashMap<contract.domain.ITeam, Team> teams = new HashMap<>();

    public Team()
    {
    }

    public static Team copy(contract.domain.ITeam team)
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
            a.setLeague(team.getLeague().getId());
            for (contract.domain.ICompetition c : team.getCompetitionList())
            {
                a.competitionList.add(c.getId());
            }

            for (contract.domain.IMatch c : team.getMatchList())
            {
                a.matchList.add(c.getId());
            }

            teams.put(team, a);
        }

        return a;
    }

    public static contract.domain.ITeam copy(ITeam team,
                                                               contract.domain.ILeague league,
                                                               List<contract.domain.ICompetition> competitionList,
                                                               List<contract.domain.IMatch> matchList)
    {
        contract.domain.ITeam a = new server.domain.classes.Team(team.getId());

        a.setName(team.getName());
        a.setDescription(team.getDescription());
        a.setLeague(league);

        a.setCompetitionList(competitionList);

        a.setMatchList(matchList);

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
    public List<Integer> getCompetitionList()
    {
        return competitionList;
    }

    @Override
    public void setCompetitionList(List<Integer> competitionList)
    {
        this.competitionList = competitionList;
    }

    @Override
    public List<Integer> getMatchList()
    {
        return matchList;
    }

    @Override
    public void setMatchList(List<Integer> matchList)
    {
        this.matchList = matchList;
    }

    @Override
    public Integer getLeague()
    {
        return league;
    }

    @Override
    public void setLeague(Integer league)
    {
        this.league = league;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
}
