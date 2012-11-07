/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap.contract;

import java.io.Serializable;

/**
 @author Thomas
 */
public interface IUserData extends Serializable 
{

    /**
     * @return the password
     */
    String getPassword();

    /**
     * @return the username
     */
    String getUsername();
    
}
