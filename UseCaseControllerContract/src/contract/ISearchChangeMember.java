/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.List;
import dto.contract.*;

/**
 *
 * @author Lucia
 */
public interface ISearchChangeMember {
    
    
    List<IMember> getMatchingMembers(String searchInput);   //find all members, matching the searched value 
    IMember getMember(/*old :String searchMember*/ Integer id); //best if MemberID could be used!?
    List<IRole> getRoles(Integer memberId);
    IDepartment getDepartment(Integer memberId);
    IAddress getAddress(Integer addressId);
    ICountry getCountry(Integer countryID);     //new added
    List<IDepartment> getDepartments();  
    List<IClubTeam> getClubTeams(List<Integer> clubTeams);
    
    void setNewMember(IMember member, IAddress address);
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role);
    
    
}
