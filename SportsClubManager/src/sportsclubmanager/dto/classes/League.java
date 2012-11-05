package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class League
        implements Serializable, ILeague
{
    private String name;
    private String description;
    private List<Team> teamList = new LinkedList<>();

    public League()
    {
    }
    private static HashMap<ILeague, League> leagues = new HashMap<>();

    public static League copy(ILeague league)
    {
        League a;

        if (leagues.containsKey(league))
        {
            a = leagues.get(league);
        }
        else
        {
            a = new League();

            a.setName(league.getName());
            a.setDescription(league.getDescription());
            a.setTeamList(league.getTeamList());

            leagues.put(league, a);
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
    public List<ITeam> getTeamList()
    {
        List<ITeam> result = new LinkedList<>();

        for (Team c : teamList)
        {
            result.add(c);
        }

        return result;
    }

    @Override
    public void setTeamList(List<ITeam> teamList)
    {
        List<Team> result = new LinkedList<>();

        for (ITeam c : teamList)
        {
            result.add(Team.copy(c));
        }

        this.teamList = result;
    }
}
