/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.List;
import sportsclubmanager.domain.classes.Team;

/**

 @author Thomas
 */
public interface IClubTeam
        extends ITeam
{
    List<IDepartment> getDepartmentList();

    List<IPlayer> getPlayerList();

    List<ITrainer> getTrainerList();

    void setDepartmentList(List<IDepartment> departmentList);

    void setPlayerList(List<IPlayer> teamhasPlayerList);

    void setTrainerList(List<ITrainer> trainerList);
}
