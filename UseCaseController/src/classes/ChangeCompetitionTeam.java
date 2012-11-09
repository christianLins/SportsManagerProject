/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import java.util.List;
/**
 *
 * @author EnjoX
 */
public class ChangeCompetitionTeam implements IChangeCompetitionTeam{

    @Override
    public List<ICompetition> getCompetition() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> Teams) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
