/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ITrainer extends IRole
{
    List<IClubTeam> getClubTeamList();

    void setClubTeamList(List<IClubTeam> clubTeamList);
}
