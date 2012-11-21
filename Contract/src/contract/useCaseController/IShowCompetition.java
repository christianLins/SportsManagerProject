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
public interface IShowCompetition
{
    List<ICompetition> getCompetitions();

    List<IMatch> getMatchs(List<Integer> matches);

    List<IPlayer> getPlayer(IClubTeam team);
}
