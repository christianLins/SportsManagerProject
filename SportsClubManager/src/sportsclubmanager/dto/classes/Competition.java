package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Competition
        implements Serializable, ICompetition
{
    private Date dateFrom;
    private Date dateTo;
    private Double payment;
    private List<Team> teamList;
    private List<Match> matchList;

    public Competition()
    {
    }
    private static HashMap<ICompetition, Competition> competitions = new HashMap<>();

    public static Competition copy(ICompetition competition)
    {
        Competition a;

        if (competitions.containsKey(competition))
        {
            a = competitions.get(competition);
        }
        else
        {
            a = new Competition();

            a.setDateFrom(competition.getDateFrom());
            a.setDateTo(competition.getDateTo());
            a.setPayment(competition.getPayment());
            a.setTeamList(competition.getTeamList());
            a.setMatchList(competition.getMatchList());

            competitions.put(competition, a);
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
    public List<ITeam> getTeamList()
    {
        List<ITeam> result = new LinkedList<>();

        for (Team c : teamList)
        {
            result.add(Team.copy(c));
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

    @Override
    public List<IMatch> getMatchList()
    {
        List<IMatch> result = new LinkedList<>();

        for (Match c : matchList)
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
}
