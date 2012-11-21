/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IPlayer;
import java.util.List;

/**

 @author Thomas
 */
public class Player
        extends Role
        implements IPlayer
{
    List<Integer> typeOfSportList;

    public List<Integer> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    public void setTypeOfSportList(List<Integer> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }
}
