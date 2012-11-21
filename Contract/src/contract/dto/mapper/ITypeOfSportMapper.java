/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.ITypeOfSport;

/**

 @author Thomas
 */
public interface ITypeOfSportMapper
        extends IMapper<ITypeOfSport>
{
    ITypeOfSport getByName(String name);
}
