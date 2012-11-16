/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper.contract;

import dto.contract.ITypeOfSport;

/**

 @author Thomas
 */
public interface ITypeOfSportMapper
        extends IMapper<ITypeOfSport>
{
    ITypeOfSport getByName(String name);
}
