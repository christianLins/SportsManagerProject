/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;

/**

 @author Thomas
 */
public interface IDepartment
{
    List<IClubTeam> getClubTeamList();

    IDepartmentHead getDepartmentHead();

    List<ITypeOfSport> getTypeOfSportList();

    String getDescription();

    String getName();

    void setClubTeamList(List<IClubTeam> clubTeamList);

    void setDepartmentHead(IDepartmentHead departmentHead);

    void setTypeOfSportList(List<ITypeOfSport> departmenthasTypeOfSportList);

    void setDescription(String description);

    void setName(String name);
}
