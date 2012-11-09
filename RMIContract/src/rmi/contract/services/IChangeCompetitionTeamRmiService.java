/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import java.util.List;
import dto.contract.*;
import java.rmi.Remote;

/**
 *
 * @author Lucia
 */
public interface IChangeCompetitionTeamRmiService extends Remote {
    
    List<ICompetition> getCompetition() ;
    List<IClubTeam> getClubTeams(List<Integer> Teams);
    void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam);
    
    
}
