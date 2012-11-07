/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import dto.contract.IMember;
import dto.controller.MemberController;
import dto.controller.contract.IdNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiMemberController extends UnicastRemoteObject implements IRmiMemberController
{
    
    private static RmiMemberController INSTANCE;
    
    private RmiMemberController() throws RemoteException {
        super();
    }
    
    public static IRmiMemberController getInstance() throws RemoteException {
        if(INSTANCE == null) INSTANCE = new RmiMemberController();
        return INSTANCE;
    }
    
    @Override
    public dto.contract.IMember getById(Integer id) throws IdNotFoundException, RemoteException
    {
        return MemberController.getInstance().getById(id);
    }

    @Override
    public List<IMember> getAll() throws RemoteException
    {
        return MemberController.getInstance().getAll();
    }

    @Override
    public void set(IMember value) throws RemoteException
    {
//        MemberController.getInstance().set(value);
    }
    
    
}
