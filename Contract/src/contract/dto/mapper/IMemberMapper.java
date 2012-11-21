/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper.contract;

import dto.contract.IMember;

/**

 @author Thomas
 */
public interface IMemberMapper
        extends IMapper<IMember>
{
    IMember getMemberByUsername(String username)
            throws NotFoundException;
}
