/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import dto.contract.IPlayer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IChangeCompetitionTeamRmiService extends Remote {
    
    List<ICompetition> getCompetition() throws RemoteException;
    List<IClubTeam> getClubTeams(List<Integer> Teams) throws RemoteException;
    void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam) throws RemoteException;
    
    IClubTeam getCompetitionTeam(IClubTeam team) throws RemoteException;       //get team for competition from this team
    List<IPlayer> getPlayers(List<Integer> players) throws RemoteException;    //get single players
}
