/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import contract.IAddMatchResults;
import java.util.List;
import dto.contract.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface IAddMatchResultsRmiService extends Remote {
    
    List<ICompetition> getCompetitionList() throws RemoteException;
    List<ITeam> getTeamList(List<Integer> team) throws RemoteException;
    List<IMatch> getMatchList(List<Integer> match) throws RemoteException;    
    void setMatchResult(IMatch match, IMatchresult matchresult) throws RemoteException;
    
    
}
