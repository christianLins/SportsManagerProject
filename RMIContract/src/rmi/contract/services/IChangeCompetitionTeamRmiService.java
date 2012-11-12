/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import java.util.List;
import dto.contract.*;
import java.io.Serializable;
import java.rmi.Remote;

/**
 *
 * @author Lucia
 */
public interface IChangeCompetitionTeamRmiService extends Serializable {
    
    List<ICompetition> getCompetition() ;
    List<IClubTeam> getClubTeams(List<Integer> Teams);
    void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam);
    
    
}
