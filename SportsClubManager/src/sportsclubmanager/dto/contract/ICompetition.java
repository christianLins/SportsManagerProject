/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.contract;

import java.util.*;

/**

 @author Thomas
 */
public interface ICompetition
        extends IDto
{
    Date getDateFrom();

    Date getDateTo();

    List<Integer> getMatchList();

    Double getPayment();

    List<Integer> getTeamList();

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<Integer> matchList);

    void setPayment(Double payment);

    void setTeamList(List<Integer> teamList);
}
