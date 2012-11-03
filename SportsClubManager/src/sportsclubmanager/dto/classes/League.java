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

    League(ILeague league)
    {
        this.name = league.getName();
        this.description = league.getDescription();

        for (ITeam c : league.getTeamList())
        {
            teamList.add(new Team(c));
        }
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
            result.add(new Team(c));
        }

        this.teamList = result;
    }
}
