package contract.rmi.services;

import contract.dto.*;
import java.rmi.*;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface INewMemberRmiService extends Remote
{
    
    void setNewMember(IMember member, IAddress address) throws RemoteException;

    List<IDepartment> getDepartments() throws RemoteException;  
    List<IClubTeam> getClubTeams(List<Integer> clubTeams) throws RemoteException;
    
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) throws RemoteException;
    
    List<ITypeOfSport> getTypeOfSports(List<Integer> typOfSportsList) throws RemoteException;
    
    List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport) throws RemoteException;
    
}
