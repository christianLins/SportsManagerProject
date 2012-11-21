/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import contract.ILogin;
import contract.MemberNotFoundException;
import dto.classes.Member;
import dto.contract.IMember;
import dto.contract.IUserData;
import dto.mapper.DtoFactory;
import dto.mapper.MemberMapper;
import dto.mapper.contract.*;
import java.rmi.RemoteException;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginController
        implements ILogin
{
    private static LoginController INSTANCE;

    private LoginController()
    {
    }

    public static ILogin getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new LoginController();
        }
        return INSTANCE;
    }

    @Override
    public IMember getMemberByUserData(IUserData userData)
            throws MemberNotFoundException
    {
        try
        {
            IMemberMapper m = DtoFactory.getMemberMapper();
            return m.getMemberByUsername(userData.getUsername());
        }
        catch (RemoteException | NotFoundException ex)
        {
            throw new MemberNotFoundException(ex);
        }
    }
}
