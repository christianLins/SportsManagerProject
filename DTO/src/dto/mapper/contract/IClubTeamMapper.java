/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper.contract;

import dto.contract.IClubTeam;
import dto.contract.ITypeOfSport;
import dto.mapper.ClubTeamNotFoundException;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IClubTeamMapper extends IMapper<IClubTeam>{
    
    public List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport) throws ClubTeamNotFoundException;
}
