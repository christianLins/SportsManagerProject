/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract.services;

import java.util.List;
import dto.contract.*;

/**
 *
 * @author Lucia
 */
public interface ISearchChangeMemberRmiService extends ISearchChangeMember implements Remote{
    
    IMember getMember(String searchMember);
    IRole getRoles(Integer memberId);
    IDepartment getDepartment(Integer memberId);
    IAddress getAddress(Integer addressId);
    List<IDepartment> getDepartments();  
    List<IClubTeam> getClubTeams(List<Integer> clubTeams);
    
    void setNewMember(IMember member, IAddress address);
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role);
    
    
}
