/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.ITypeOfSport;
import contract.dto.ILeague;

/**
 @author Thomas
 */
public interface ILeagueMapper
        extends IMapper<ILeague>
{
    public ILeague getByName(String league, ITypeOfSport typeOfSport)
            throws NotFoundException;
}
