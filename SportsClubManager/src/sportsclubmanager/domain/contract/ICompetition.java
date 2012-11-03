/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;
import javax.xml.bind.annotation.*;

/**

 @author Thomas
 */
public interface ICompetition
{
    Date getDateFrom();

    Date getDateTo();

    List<IMatch> getMatchList();

    Double getPayment();

    List<ITeam> getTeamList();

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<IMatch> matchList);

    void setPayment(Double payment);

    void setTeamList(List<ITeam> teamList);
    
}
