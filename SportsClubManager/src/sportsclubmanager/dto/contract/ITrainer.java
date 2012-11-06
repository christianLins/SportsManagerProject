/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ITrainer
{
    List<Integer> getClubTeamList();

    void setClubTeamList(List<Integer> clubTeamList);
}
