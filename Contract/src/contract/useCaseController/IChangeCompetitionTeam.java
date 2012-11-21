/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public interface IChangeCompetitionTeam
{
    List<ICompetition> getCompetition();

    List<IClubTeam> getClubTeams(List<Integer> Teams);

    IClubTeam getCompetitionTeam(IClubTeam team);       //get team for competition from this team

    List<IPlayer> getPlayers(List<Integer> players);    //get single players

    void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam);

    public List<IClubTeam> getClubTeams();
}
