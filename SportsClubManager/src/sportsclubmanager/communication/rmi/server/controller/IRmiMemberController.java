/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server.controller;

import java.rmi.RemoteException;
import java.util.List;
import sportsclubmanager.dto.controller.contract.IdNotFoundException;
import sportsclubmanager.dto.contract.IMember;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface IRmiMemberController
{

    List<IMember> getAll() throws RemoteException;

    IMember getById(Integer id) throws IdNotFoundException, RemoteException;

    void set(sportsclubmanager.domain.contract.IMember value) throws RemoteException;
    
}
