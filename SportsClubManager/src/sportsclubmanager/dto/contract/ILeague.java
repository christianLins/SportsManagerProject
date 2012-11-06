/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ILeague
{
    Integer getId();

    String getDescription();

    String getName();

    List<Integer> getTeamList();

    void setDescription(String description);

    void setName(String name);

    void setTeamList(List<Integer> teamList);
}
