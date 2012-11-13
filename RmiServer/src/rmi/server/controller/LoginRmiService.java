/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import classes.LoginController;
import dto.contract.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.contract.services.ILoginRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class LoginRmiService extends UnicastRemoteObject implements ILoginRmiService
{
    
    public LoginRmiService() throws RemoteException {
        super();
    }

    @Override
    public IMember getMemberByUserData(IUserData userData) throws RemoteException
    {
         return LoginController.getInstance().getMemberByUserData(userData );
    }
    

   
    
}
