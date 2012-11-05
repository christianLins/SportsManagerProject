/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.Date;

/**

 @author Thomas
 */
public interface IMatch
{
      Integer getId();

      ICompetition getCompetition();
    
    Date getDateFrom();

    Date getDateTo();

    ITeam getForeignteam();

    ITeam getHometeam();

    IMatchresult getMatchresult();

     void setCompetition(ICompetition competition);
    
     void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setForeignteam(ITeam foreignteam);

    void setHometeam(ITeam hometeam);

    void setMatchresult(IMatchresult matchresult);
}
