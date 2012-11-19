package dto.classes;

import dto.contract.ICompetition;
import java.io.Serializable;
import java.util.*;

public class Competition
        implements Serializable, ICompetition
{
    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Double payment;
    private Integer league;
    private Integer sport;
    private List<Integer> teamList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();
    private Integer address;
    private String description;
    private String name;

    public Competition()
    {
    }

    public Competition(int id)
    {
        this.id = id;
    }
    private static HashMap<domain.contract.ICompetition, Competition> competitions = new HashMap<>();

    public static Competition copy(domain.contract.ICompetition competition)
    {
        Competition a;

        if (competitions.containsKey(competition))
        {
            a = competitions.get(competition);
        }
        else
        {
            a = new Competition(competition.getId());

            a.setDateFrom(competition.getDateFrom());
            a.setDateTo(competition.getDateTo());
            a.setPayment(competition.getPayment());
            a.setLeague(competition.getLeague().getId());
            a.setSport(competition.getSport().getId());
            a.setAddress(competition.getAddress().getId());
            a.setName(competition.getName());
            a.setDescription(competition.getDescription());

            for (domain.contract.ITeam d : competition.getTeamList())
            {
                a.teamList.add(d.getId());
            }

            for (domain.contract.IMatch d : competition.getMatchList())
            {
                a.matchList.add(d.getId());
            }
            competitions.put(competition, a);
        }

        return a;
    }

    @Override
    public Integer getId()
    {
        return id;
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
    public Double getPayment()
    {
        return payment;
    }

    @Override
    public void setPayment(Double payment)
    {
        this.payment = payment;
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
        return this.league;
    }

    @Override
    public Integer getSport()
    {
        return this.sport;
    }

    @Override
    public void setSport(Integer typeOfSport)
    {
        this.sport = typeOfSport;
    }

    @Override
    public void setLeague(Integer league)
    {
        this.league = league;
    }

    @Override
    public Integer getAddress()
    {
        return this.address;
    }

    @Override
    public void setAddress(Integer address)
    {
        this.address = address;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return this.description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
