/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IMatchresult;
import dto.contract.ITeam;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IAddMatchResults {
    
    List<ICompetition> getCompetitionList();
    List<ITeam> getTeamList(List<Integer> team);
    List<IMatch> getMatchList(List<Integer> match);    
    void setMatchResult(IMatch match, IMatchresult matchresult);
    
    
}
