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
public interface INewCompetitionRmiService
        extends Remote
{
    void setCompetition(ICompetition competition, IMember member)
            throws RemoteException;

    List<ITeam> getTeams()
            throws RemoteException;
}
