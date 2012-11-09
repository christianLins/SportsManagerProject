/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import java.util.List;
import dto.contract.*;
import contract.ShowMatchObj;

/**
 *
 * @author Lucia
 */
public interface IShowCompetitionRmiService extends IShowCompetition implements Remote{
    
    List<ICompetition> getCompetitions();
    List<IMatch> getMatchs(List<Integer> matches);
    List<ShowMatchObj> getTeams(List<Integer> matches);
    IPlayer getPlayer(IClubTeam team);
    
    
}
