/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import contract.INewCompetition;
import java.util.List;
import dto.contract.*;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface INewCompetitionRmiService extends Serializable {
    
    void setCompetition(ICompetition competition, IMember member) throws RemoteException;
    List<ITeam> getTeams()  throws RemoteException;
    
}
