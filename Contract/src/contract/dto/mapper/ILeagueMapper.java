/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.ITypeOfSportDto;
import contract.dto.ILeagueDto;

/**
 @author Thomas
 */
public interface ILeagueMapper
        extends IMapper<ILeagueDto>
{
    public ILeagueDto getByName(String league, ITypeOfSportDto typeOfSport)
            throws NotFoundException;
}
