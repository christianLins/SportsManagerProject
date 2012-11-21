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
public interface ISearchChangeMemberRmiService
        extends Remote
{
    IMember getMember(int searchMember)
            throws RemoteException;

    List<IRole> getRoles(Integer memberId)
            throws RemoteException;

    IDepartment getDepartment(Integer memberId)
            throws RemoteException;

    IAddress getAddress(Integer addressId)
            throws RemoteException;

    List<IDepartment> getDepartments()
            throws RemoteException;

    List<IClubTeam> getClubTeams(List<Integer> clubTeams)
            throws RemoteException;

    void setNewMember(IMember member, IAddress address)
            throws RemoteException;

    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role)
            throws RemoteException;

    List<IMember> getMatchingMembers(String searchInput)
            throws RemoteException;   //find all members, matching the searched value 

    ICountry getCountry(Integer countryID)
            throws RemoteException;     //new added

    List<ITypeOfSport> getTypeOfSports(List<Integer> sportsList)
            throws RemoteException;     //new added

    IMember getSelectedMember()
            throws RemoteException;     //new added

    void setSelectedMember(IMember selectedMember)
            throws RemoteException;     //new added
}
