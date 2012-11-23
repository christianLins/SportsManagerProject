/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto.mapper;

import contract.dto.IMemberDto;

/**

 @author Thomas
 */
public interface IMemberMapper
        extends IMapper<IMemberDto>
{
    IMemberDto getMemberByUsername(String username)
            throws NotFoundException;
}
