/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface IClubTeam
        extends ITeam
{
    List<Integer> getDepartmentList();

    List<Integer> getPlayerList();

    List<Integer> getTrainerList();

    void setDepartmentList(List<Integer> departmentList);

    void setPlayerList(List<Integer> teamhasPlayerList);

    void setTrainerList(List<Integer> trainerList);
}
