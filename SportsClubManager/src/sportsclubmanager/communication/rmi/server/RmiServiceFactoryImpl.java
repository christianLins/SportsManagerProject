/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server;

import sportsclubmanager.communication.rmi.server.service.RmiServiceFactory;
import sportsclubmanager.controller.CompetitionService;
import sportsclubmanager.controller.MemberService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import sportsclubmanager.controller.CompetitionController;
import sportsclubmanager.controller.MemberController;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceFactoryImpl extends UnicastRemoteObject implements RmiServiceFactory
{
    
    public RmiServiceFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public CompetitionService getCompetitionManager() throws RemoteException
    {
        return CompetitionController.getInstance();
    }

    @Override
    public MemberService getMemberManager() throws RemoteException
    {
        return MemberController.getInstance();
    }

    
    
}
