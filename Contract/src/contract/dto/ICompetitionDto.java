/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.io.Serializable;
import java.util.*;

/**

 @author Thomas
 */
public interface ICompetitionDto
        extends Serializable, IDto
{
    Date getDateFrom();

    Date getDateTo();

    List<Integer> getMatchList();

    Double getPayment();

    List<Integer> getTeamList();

    Integer getLeague();

    Integer getSport();

    Integer getAddress();

    String getName();

    String getDescription();

    void setAddress(Integer address);

    void setSport(Integer typeOfSport);

    void setLeague(Integer league);

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setMatchList(List<Integer> matchList);

    void setPayment(Double payment);

    void setTeamList(List<Integer> teamList);

    void setName(String name);

    void setDescription(String description);
}
