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
    
    void setNewMember(IMemberDto member, IAddressDto address) throws RemoteException;

    List<IDepartmentDto> getDepartments() throws RemoteException;  
    List<IClubTeamDto> getClubTeams(List<Integer> clubTeams) throws RemoteException;
    
    void setNewMember(IMemberDto member, IAddressDto address, IDepartmentDto department, IClubTeamDto clubTeam, IRoleDto role) throws RemoteException;
    
    List<ITypeOfSportDto> getTypeOfSports(List<Integer> typOfSportsList) throws RemoteException;
    
    List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport) throws RemoteException;
    
}
