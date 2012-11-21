/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.domain;

import java.util.*;

/**
 @author Thomas
 */
public interface ICompetition
        extends IDomain
{
    String getName();

    String getDescription();

    IAddress getAddress();

    Date getDateFrom();

    Date getDateTo();

    List<IMatch> getMatchList();

    Double getPayment();

    List<ITeam> getTeamList();

    ILeague getLeague();

    ITypeOfSport getSport();

    void setName(String name);

    void setDescription(String description);

    void setAddress(IAddress address);

    void setSport(ITypeOfSport sport);

    void setLeague(ILeague league);

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<IMatch> matchList);

    void setPayment(Double payment);

    void setTeamList(List<ITeam> teamList);
}
