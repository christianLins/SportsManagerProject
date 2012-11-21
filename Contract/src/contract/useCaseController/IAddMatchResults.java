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
public interface IAddMatchResults
{
    List<ICompetition> getCompetitionList();

    List<ITeam> getTeamList(List<Integer> team);

    List<IMatch> getMatchList(List<Integer> match);

    void setMatchResult(IMatch match, IMatchresult matchresult);
}
