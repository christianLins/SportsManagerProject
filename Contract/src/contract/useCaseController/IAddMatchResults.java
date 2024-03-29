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
    List<ICompetitionDto> getCompetitionList();

    List<ITeamDto> getTeamList(List<Integer> team);

    List<IMatchDto> getMatchList(List<Integer> match);

    void setMatchResult(IMatchDto match, IMatchresultDto matchresult);
}
