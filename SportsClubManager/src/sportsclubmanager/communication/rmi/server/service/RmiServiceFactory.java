/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server.service;

import sportsclubmanager.controller.MemberService;
import sportsclubmanager.controller.CompetitionService;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface RmiServiceFactory extends Remote
{
    
    public CompetitionService getCompetitionManager() throws RemoteException;
    public MemberService getMemberManager() throws RemoteException;
    
}
