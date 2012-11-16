/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

import java.util.*;

/**
 @author Thomas
 */
public interface ICompetition extends IDomain
{
    Date getDateFrom();

    Date getDateTo();

    List<IMatch> getMatchList();

    Double getPayment();

    List<ITeam> getTeamList();
    
    ILeague getLeague();
    
    ITypeOfSport getSport();
    
    void setSport(ITypeOfSport sport);
    
    void setLeague(ILeague league);

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<IMatch> matchList);

    void setPayment(Double payment);

    void setTeamList(List<ITeam> teamList);
}
