package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.dto.contract.*;

public class Competition
        implements Serializable, ICompetition
{
    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Double payment;
    private List<Integer> teamList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();

    public Competition()
    {
    }

    public Competition(int id)
    {
        this.id = id;
    }
    private static HashMap<sportsclubmanager.domain.contract.ICompetition, Competition> competitions = new HashMap<>();

    public static Competition copy(sportsclubmanager.domain.contract.ICompetition competition)
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

            for (sportsclubmanager.domain.contract.ITeam d : competition.getTeamList())
            {
                a.teamList.add(d.getId());
            }

            for (sportsclubmanager.domain.contract.IMatch d : competition.getMatchList())
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
}
