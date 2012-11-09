/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import java.util.List;
import dto.contract.*;
import contract.ShowMatchObj;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface IShowCompetitionRmiService extends Remote{
    
    List<ICompetition> getCompetitions() throws RemoteException;
    List<IMatch> getMatchs(List<Integer> matches) throws RemoteException;
    List<ShowMatchObj> getTeams(List<Integer> matches) throws RemoteException;
    IPlayer getPlayer(IClubTeam team) throws RemoteException;
    
    
}
