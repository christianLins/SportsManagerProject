package contract;

import java.util.List;
import dto.contract.*;

/**
 *
 * @author Lucia
 */
public interface INewMember {
    
    void setNewMember(IMember member, IAddress address);

    List<IDepartment> getDepartments();  
    List<IClubTeam> getClubTeams(List<Integer> clubTeams);
    List<ITypeOfSport> getTypeOfSports(List<Integer> typOfSportsList);
    
    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role);
    
}
