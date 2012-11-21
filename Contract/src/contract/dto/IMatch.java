/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.Date;

/**

 @author Thomas
 */
public interface IMatch
        extends IDto
{
    Integer getCompetition();

    Date getDateFrom();

    Date getDateTo();

    ITeam getForeignteam();

    ITeam getHometeam();

    IMatchresult getMatchresult();

    void setCompetition(Integer competition);

    void setDateFrom(Date dateFrom);

    void setDateTo(Date dateTo);

    void setForeignteam(Integer foreignteam);

    void setHometeam(Integer hometeam);

    void setMatchresult(Integer matchresult);
}
