/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.*;
import java.rmi.*;
import java.util.List;

/**
 @author Lucia
 */
public interface IShowCompetitionRmiService
        extends Remote
{
    List<ICompetition> getCompetitions()
            throws RemoteException;

    List<IMatch> getMatchs(List<Integer> matches)
            throws RemoteException;

    List<IPlayer> getPlayer(IClubTeam team)
            throws RemoteException;
}
