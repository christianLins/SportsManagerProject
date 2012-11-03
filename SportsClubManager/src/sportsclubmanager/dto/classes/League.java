package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class League
        implements Serializable, ILeague
{
    private String name;
    private String description;
    private List<Team> teamList;

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
        return teamList;
    }

    @Override
    public void setTeamList(List<ITeam> teamList)
    {
        this.teamList = teamList;
    }
}
