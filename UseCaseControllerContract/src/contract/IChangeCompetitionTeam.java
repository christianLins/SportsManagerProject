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
public interface IChangeCompetitionTeam {
    
    List<ICompetition> getCompetition();
    List<IClubTeam> getClubTeams(List<Integer> Teams);
    void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam);

    public List<IClubTeam> getClubTeams();
    
    
}
