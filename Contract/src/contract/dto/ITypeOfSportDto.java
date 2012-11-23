/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface ITypeOfSportDto
        extends IDto
{
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<Integer> getPlayerList();

    void setPlayerList(List<Integer> playerList);
    
}
