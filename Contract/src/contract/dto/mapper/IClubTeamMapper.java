/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.IClubTeamDto;
import contract.dto.ITypeOfSportDto;
import java.util.List;

/**
 *
 * @author Lucia
 */
public interface IClubTeamMapper extends IMapper<IClubTeamDto>{
    
    public List<IClubTeamDto> getClubTeamsByTypeOfSport(ITypeOfSportDto sport) throws ClubTeamNotFoundException;
}
