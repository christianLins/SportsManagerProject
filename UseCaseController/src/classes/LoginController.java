/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import contract.ILogin;
import dto.contract.IMember;
import dto.contract.IUserData;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginController implements ILogin
{
    private static LoginController INSTANCE;

    private LoginController()
    {
    }
    
    public static ILogin getInstance() {
        if(INSTANCE == null) INSTANCE = new LoginController();
        return INSTANCE;
    }

    @Override
    public IMember getMemberByUserData(IUserData userData)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
