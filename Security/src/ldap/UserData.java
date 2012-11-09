/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap;

import ldap.contract.IUserData;

/**
 @author Thomas
 */
public class UserData
        implements IUserData
{
    private String username;
    private String password;

    public UserData(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    /**
     @return the username
     */
    @Override
    public String getUsername()
    {
        return username;
    }

    /**
     @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     @return the password
     */
    @Override
    public String getPassword()
    {
        return password;
    }

    /**
     @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
}
