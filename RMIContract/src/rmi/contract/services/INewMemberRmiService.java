package rmi.contract.services;

import java.util.List;
import dto.contract.*;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucia
 */
public interface INewMemberRmiService extends Serializable
{
    
    void setNewMember(IMember member, IAddress address) throws RemoteException;

    List<IDepartment> getDepartments();  
    List<IClubTeam> getClubTeams(List<Integer> clubTeams) throws RemoteException;
    
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) throws RemoteException;
    
}
