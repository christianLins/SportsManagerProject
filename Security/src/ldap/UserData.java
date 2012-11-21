/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap;

import contract.dto.IUserData;

/**
 @author Thomas
 */
public class UserData
        implements IUserData
{
    private String username;
    private String password;
    private String ip;

    public UserData(String username, String password, String ip)
    {
        this.username = username;
        this.password = password;
        this.ip = ip;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
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

    @Override
    public String getIP()
    {
        return ip;
    }
}
