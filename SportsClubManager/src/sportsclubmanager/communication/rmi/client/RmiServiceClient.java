/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sportsclubmanager.controller.CompetitionService;
import sportsclubmanager.controller.MemberService;
import sportsclubmanager.communication.rmi.server.service.RmiServiceFactory;

/**
 * this class provides the server-side services via rmi
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClient
{
    private final String host;
    private final int port;
    
    private RmiServiceFactory factory;
    
    /**
     * instantiate a new rmi-service-client by passing host and port of the server
     * 
     * @param host
     * @param port
     * 
     * @throws CommunicationProblemException (invalid host/port)
     */
    public RmiServiceClient(String host, int port) throws CommunicationProblemException {
        if(host == null || port == 0) throw new NullPointerException();
        this.host = host;
        this.port = port;
        initConnection();
    }

    private void initConnection() throws CommunicationProblemException
    {        
        try
        {
            factory = (RmiServiceFactory) Naming.lookup("rmi://" + host + ":" + port + "/RmiSportsClubManagerServiceFactory");
        } catch( RemoteException | MalformedURLException | NotBoundException e) {
            throw new CommunicationProblemException("Connection could not be established", e);
        }
    }
    
    /**
     * you get a competition service object from the server
     * 
     * @return
     * @throws RemoteException 
     */
    public CompetitionService getCompetitionManager() throws CommunicationProblemException {
        CompetitionService competitionManager;
        try
        {
            competitionManager = factory.getCompetitionManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
        return competitionManager;
    }
    
    /**
     * you get a member service object from the server
     * 
     * @return
     * @throws RemoteException 
     */
    public MemberService getMemberManager() throws CommunicationProblemException {
        MemberService memberManager = null;
        try
        {
            memberManager = factory.getMemberManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
        return memberManager;
    }
    
    
}
