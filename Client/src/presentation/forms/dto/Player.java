/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IPlayerDto;
import java.util.List;

/**

 @author Thomas
 */
public class Player
        extends Role
        implements IPlayerDto
{
    List<Integer> typeOfSportList;
    List<Integer> selectedTeams;

    @Override
    public List<Integer> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    @Override
    public void setTypeOfSportList(List<Integer> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }

    @Override
    public void setClubTeamList(List<Integer> selectedTeams)
    {
        this.selectedTeams = selectedTeams;
    }

    @Override
    public List<Integer> getClubTeamList()
    {
        return selectedTeams;
    }
}
