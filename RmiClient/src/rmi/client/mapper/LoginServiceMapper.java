/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.ILogin;
import dto.contract.IMember;
import dto.contract.IUserData;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.contract.services.ILoginRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginServiceMapper implements RmiServiceToServiceMapper<ILoginRmiService, ILogin>
{

    @Override
    public ILogin getService(ILoginRmiService rmiService)
    {
        Login n = new Login();
        n.setService(rmiService);
        return n;  
    }
    
    class Login implements ILogin {
        
         private ILoginRmiService service;
        
        
        public void setService(ILoginRmiService service) {
            this.service = service;
        }

        @Override
        public IMember getMemberByUserData(IUserData userData)
        {
            try
            {
                return service.getMemberByUserData(userData);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(LoginServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
    }
    
}
