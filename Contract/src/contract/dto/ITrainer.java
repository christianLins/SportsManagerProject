/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ITrainer
        extends IRole
{
    List<Integer> getClubTeamList();

    void setClubTeamList(List<Integer> clubTeamList);

    List<Integer> getTypeOfSportList();

    void setTypeOfSportList(List<Integer> typeOfSportList);
}
