package ldap.contract;

import contract.dto.IUserDataDto;


/**
 @author Thomas
 */
public interface IAuthenticator
{
    boolean auth(IUserDataDto userData);
}
