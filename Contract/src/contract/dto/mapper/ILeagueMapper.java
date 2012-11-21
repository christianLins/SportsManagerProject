/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper.contract;

import dto.contract.*;

/**

 @author Thomas
 */
public interface ILeagueMapper extends IMapper<ILeague>
{
    public ILeague getByName(String league, ITypeOfSport typeOfSport) throws NotFoundException;
}
