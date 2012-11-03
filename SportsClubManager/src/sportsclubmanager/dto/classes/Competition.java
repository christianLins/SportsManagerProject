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
        return teamList;
    }

    @Override
    public void setTeamList(List<ITeam> teamList)
    {
        this.teamList = teamList;
    }

    @Override
    public List<IMatch> getMatchList()
    {
        return matchList;
    }

    @Override
    public void setMatchList(List<IMatch> matchList)
    {
        this.matchList = matchList;
    }
}
