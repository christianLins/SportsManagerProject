/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.List;
import dto.contract.*;

/**
 *
 * @author Lucia
 */
public interface INewCompetition {
    
    void setCompetition(ICompetition competition, IMember member);
    List<ITeam> getTeams();
    
}
