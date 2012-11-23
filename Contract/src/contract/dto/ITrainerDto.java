/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface ITrainerDto
        extends IRoleDto
{
    List<Integer> getClubTeamList();

    void setClubTeamList(List<Integer> clubTeamList);

    List<Integer> getTypeOfSportList();

    void setTypeOfSportList(List<Integer> typeOfSportList);
}
