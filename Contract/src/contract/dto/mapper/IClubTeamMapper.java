/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.IClubTeam;
import contract.dto.ITypeOfSport;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IClubTeamMapper extends IMapper<IClubTeam>{
    
    public List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport) throws ClubTeamNotFoundException;
}
