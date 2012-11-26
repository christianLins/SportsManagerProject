/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface IPlayerDto
        extends IRoleDto
{
    List<Integer> getTypeOfSportList();

    void setTypeOfSportList(List<Integer> typeOfSportList);

    void setClubTeamList(List<Integer> selectedTeams);

    List<Integer> getClubTeamList();
}
