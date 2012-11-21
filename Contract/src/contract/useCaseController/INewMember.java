package contract.useCaseController;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public interface INewMember
{
    void setNewMember(IMember member, IAddress address);

    List<IDepartment> getDepartments();

    List<IClubTeam> getClubTeams(List<Integer> clubTeams);

    List<ITypeOfSport> getTypeOfSports(List<Integer> typOfSportsList);
    
    List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport);

    void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role);
}
