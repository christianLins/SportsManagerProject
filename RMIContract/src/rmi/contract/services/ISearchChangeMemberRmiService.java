/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import java.util.List;
import dto.contract.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface ISearchChangeMemberRmiService extends Remote{
    
    IMember getMember(String searchMember) throws RemoteException;
    IRole getRoles(Integer memberId) throws RemoteException;
    IDepartment getDepartment(Integer memberId) throws RemoteException;
    IAddress getAddress(Integer addressId) throws RemoteException;
    List<IDepartment> getDepartments() throws RemoteException;
    List<IClubTeam> getClubTeams(List<Integer> clubTeams) throws RemoteException;
    
    void setNewMember(IMember member, IAddress address) throws RemoteException;
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) throws RemoteException;
    
    
}
