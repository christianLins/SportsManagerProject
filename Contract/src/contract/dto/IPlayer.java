/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface IPlayer
        extends IRole
{
    List<Integer> getTypeOfSportList();

    void setTypeOfSportList(List<Integer> typeOfSportList);
}
