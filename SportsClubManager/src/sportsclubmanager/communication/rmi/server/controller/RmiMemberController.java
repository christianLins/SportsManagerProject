/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import sportsclubmanager.controller.MemberController;
import sportsclubmanager.controller.contract.IdNotFoundException;
import sportsclubmanager.domain.contract.IMember;

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
    public sportsclubmanager.dto.contract.IMember getById(Integer id) throws IdNotFoundException, RemoteException
    {
        return MemberController.getInstance().getById(id);
    }

    @Override
    public List<sportsclubmanager.dto.contract.IMember> getAll() throws RemoteException
    {
        return MemberController.getInstance().getAll();
    }

    @Override
    public void set(IMember value) throws RemoteException
    {
//        MemberController.getInstance().set(value);
    }
    
    
}
