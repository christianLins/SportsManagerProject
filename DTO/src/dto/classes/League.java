package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.ILeague;

public class League
        implements Serializable, ILeague
{
    private int id;
    private String name;
    private String description;
    private List<Integer> teamList = new LinkedList<>();

     League()
    {
    }

     League(int id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
    private static HashMap<domain.contract.ILeague, League> leagues = new HashMap<>();

    public static League copy(domain.contract.ILeague league)
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

            for (domain.contract.ITeam d : league.getTeamList())
            {
                a.teamList.add(d.getId());
            }

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
    public List<Integer> getTeamList()
    {
        return teamList;
    }

    @Override
    public void setTeamList(List<Integer> teamList)
    {
        this.teamList = teamList;
    }
}
