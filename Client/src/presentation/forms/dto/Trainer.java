/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.ITrainerDto;
import java.util.List;

/**

 @author Thomas
 */
public class Trainer
        extends Role
        implements ITrainerDto
{
    List<Integer> ClubTeamList;
    List<Integer> typeOfSportList;

    public Trainer()
    {
    }

    @Override
    public List<Integer> getClubTeamList()
    {
        return ClubTeamList;
    }

    @Override
    public void setClubTeamList(List<Integer> ClubTeamList)
    {
        this.ClubTeamList = ClubTeamList;
    }

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
}
