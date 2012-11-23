/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.ITypeOfSportDto;

/**

 @author Thomas
 */
public interface ITypeOfSportMapper
        extends IMapper<ITypeOfSportDto>
{
    ITypeOfSportDto getByName(String name);
}
