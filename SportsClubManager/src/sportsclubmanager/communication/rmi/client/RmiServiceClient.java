/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import sportsclubmanager.controller.CompetitionService;
import sportsclubmanager.controller.MemberService;
import sportsclubmanager.communication.rmi.server.service.RmiServiceFactory;

/**
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
            throw new CommunicationProblemException(e);
        }
    }
    
    
    public CompetitionService getCompetitionManager() throws RemoteException {
        return factory.getCompetitionManager();
    }
    
    public MemberService getMemberManager() throws RemoteException {
        return factory.getMemberManager();
    }
    
    
}
