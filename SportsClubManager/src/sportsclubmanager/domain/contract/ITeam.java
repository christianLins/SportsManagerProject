/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**

 @author Thomas
 */
public interface ITeam
{
    @XmlTransient
    List<ICompetition> getCompetitionList();

    String getDescription();

    ILeague getLeague();

    @XmlTransient
    List<IMatch> getMatchList();

    String getName();

    void setCompetitionList(List<ICompetition> competitionList);

    void setDescription(String description);

    void setLeague(ILeague league);

    void setMatchList(List<IMatch> matchList);

    void setName(String name);
}
