package ldap.contract;

import contract.dto.IUserData;


/**
 @author Thomas
 */
public interface IAuthenticator
{
    boolean auth(IUserData userData);
}
