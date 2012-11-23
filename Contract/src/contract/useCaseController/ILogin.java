/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.useCaseController;

import contract.dto.*;

/**

 @author Lucia
 */
public interface ILogin
{
    IMemberDto getMemberByUserData(IUserDataDto userData)
            throws MemberNotFoundException;
}
