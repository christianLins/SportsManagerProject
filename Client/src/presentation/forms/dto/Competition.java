/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.*;
import java.util.*;

/**

 @author Thomas
 */
public class Competition
        implements ICompetitionDto
{
    Date dateFrom;
    Date dateTo;
    List<Integer> matchList;

    public Date getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo()
    {
        return dateTo;
    }

    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    public List<Integer> getMatchList()
    {
        return matchList;
    }

    public void setMatchList(List<Integer> matchList)
    {
        this.matchList = matchList;
    }

    public Double getPayment()
    {
        return payment;
    }

    public void setPayment(Double payment)
    {
        this.payment = payment;
    }

    public List<Integer> getTeamList()
    {
        return teamList;
    }

    public void setTeamList(List<Integer> teamList)
    {
        this.teamList = teamList;
    }

    public Integer getLeague()
    {
        return league;
    }

    public void setLeague(Integer league)
    {
        this.league = league;
    }

    public Integer getSport()
    {
        return sport;
    }

    public void setSport(Integer sport)
    {
        this.sport = sport;
    }

    public Integer getAddress()
    {
        return address;
    }

    public void setAddress(Integer address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    Double payment;
    List<Integer> teamList;
    Integer league;
    Integer sport;
    Integer address;
    String name;
    String description;

    @Override
    public Integer getId()
    {
        return null;
    }
}
