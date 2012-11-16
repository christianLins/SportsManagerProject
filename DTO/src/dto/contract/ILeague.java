/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.Date;
import java.util.List;

/**

 @author Thomas
 */
public interface ILeague
        extends IDto
{
    String getDescription();

    String getName();

    List<Integer> getTeamList();
    
    List<Integer> getCompetitions();
    
    void setCompetitions(List<Integer> competitions);

    void setDescription(String description);

    void setName(String name);

    void setTeamList(List<Integer> teamList);

    public List<ICompetition> getCompetitionList(Date date);
}
