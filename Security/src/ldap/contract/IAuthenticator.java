/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap.contract;

import ldap.contract.IUserData;

/**

 @author Thomas
 */
public interface IAuthenticator
{
    boolean auth(IUserData userData);
}
