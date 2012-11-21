/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.rmi.services;

import contract.dto.IMember;
import contract.dto.IUserData;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface ILoginRmiService extends Remote {
    IMember  getMemberByUserData(IUserData userData) throws RemoteException;
}
