/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

import domain.classes.Competition;
import java.util.*;
import javax.xml.bind.annotation.*;

/**

 @author Thomas
 */
public interface ILeague extends IDomain
{
    String getDescription();

    String getName();

    List<ITeam> getTeamList();
    
    List<ICompetition> getCompetitions();
    
    void setCompetitions(List<Competition> competitions);

    void setDescription(String description);

    void setName(String name);

    void setTeamList(List<ITeam> teamList);
}
