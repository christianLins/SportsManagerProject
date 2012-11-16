/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ITypeOfSport
        extends IDto
{
    String getName();
    
    List<Integer> getCompetitions();
    
    void setCompetitions(List<Integer> competitions);

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<Integer> getPlayerList();

    void setPlayerList(List<Integer> playerList);
}
