/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface INewCompetition {
    
    void setCompetition(ICompetition competition, IMember member);
    List<ITeam> getTeams();
    
}
