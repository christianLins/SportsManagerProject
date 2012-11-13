/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import contract.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.client.mapper.AddMatchResultsServiceMapper;
import rmi.contract.RmiServiceClient;
import rmi.contract.services.IAddMatchResultsRmiService;
import services.ServiceClient;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClientImpl implements ServiceClient
{
    private String host;
    private int port;
    private RmiServiceClient rmiServiceClient;

    public RmiServiceClientImpl(String host, int port) throws CommunicationProblemException
    {
        this.host = host;
        this.port = port;
        init();
    }
    

   

    private void init() throws CommunicationProblemException
    {
//        String setProperty = System.setProperty("java.security.policy", "./client.policy");
//        
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        } 
        
        try
        {
            
            rmiServiceClient = (RmiServiceClient) Naming.lookup("rmi://" + host + ":" + port + "/CommunicationFactory");
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex)
        {
            ex.printStackTrace();
            throw new CommunicationProblemException(host, ex);
        }
    }

    @Override
    public IAddMatchResults getAddMatchResultsService() throws ServiceNotAvailableException
    {
        try
        {
            IAddMatchResultsRmiService rmiService = rmiServiceClient.getAddMatchResultsService();
            AddMatchResultsServiceMapper map = new AddMatchResultsServiceMapper();
            return map.getService(rmiService);
        }
        catch (RemoteException ex)
        {
            ex.printStackTrace();
            throw new ServiceNotAvailableException("Service AddMatchResults not available", ex);
        }
    }

    @Override
    public IChangeCompetitionTeam getChangeCompetitionTeamService() throws ServiceNotAvailableException
    {
         try
        {
            return (IChangeCompetitionTeam) rmiServiceClient.getChangeCompetitionTeamService();
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service ChangeCompetitionTeam not available", ex);
        }
    }

    @Override
    public INewCompetition getNewCompetitionService() throws ServiceNotAvailableException
    {
         try
        {
            return (INewCompetition) rmiServiceClient.getNewCompetitionService();
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service NewCompetitionService not available", ex);
        }
    }

    @Override
    public INewMember getNewMemberService() throws ServiceNotAvailableException
    {
          try
        {
            return (INewMember) rmiServiceClient.getNewMemberService();
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service NewMemberService not available", ex);
        }
    }

    @Override
    public ISearchChangeMember getSearchChangeMemberService() throws ServiceNotAvailableException
    {
           try
        {
            return (ISearchChangeMember) rmiServiceClient.getSearchChangeMemberService();
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service SearchChangeMember not available", ex);
        }
    }

    @Override
    public IShowCompetition getShowCompetitionService() throws ServiceNotAvailableException
    {
        try
        {
            return (IShowCompetition) rmiServiceClient.getShowCompetitionService();
        }
        catch (RemoteException ex)
        {
            throw new ServiceNotAvailableException("Service ShowCompetition not available", ex);
        }
    }
 
    
    
}
