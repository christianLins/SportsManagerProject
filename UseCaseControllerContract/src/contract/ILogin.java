/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import dto.contract.IMember;
import dto.contract.IUserData;

/**
 *
 * @author Lucia
 */
public interface ILogin {

    IMember getMemberByUserData(IUserData userData);
}
