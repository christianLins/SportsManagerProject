/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IMatchresult;
import dto.contract.ITeam;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IAddMatchResultsRmiService extends Serializable {
    
    List<ICompetition> getCompetitionList() throws RemoteException;
    List<ITeam> getTeamList(List<Integer> team) throws RemoteException;
    List<IMatch> getMatchList(List<Integer> match) throws RemoteException;    
    void setMatchResult(IMatch match, IMatchresult matchresult) throws RemoteException;
    
    
}
