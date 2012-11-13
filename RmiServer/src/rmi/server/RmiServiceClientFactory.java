/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import classes.AddMatchResults;
import contract.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.contract.RmiServiceClient;
import rmi.contract.services.*;
import rmi.server.controller.*;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClientFactory extends UnicastRemoteObject implements RmiServiceClient
{
    
    public RmiServiceClientFactory() throws RemoteException {
        super();
    }

    @Override
    public rmi.contract.services.IAddMatchResultsRmiService getAddMatchResultsService() throws RemoteException
    {
       return new AddMatchResultsRmiService();
    }

    @Override
    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService() throws RemoteException
    {
        return new ChangeCompetitionTeamRmiService();
    }

    @Override
    public INewCompetitionRmiService getNewCompetitionService() throws RemoteException
    {
        return new NewCompetitionRmiService();
    }

    @Override
    public INewMemberRmiService getNewMemberService() throws RemoteException
    {
        return new NewMemberRmiService();
    }

    @Override
    public ISearchChangeMemberRmiService getSearchChangeMemberService() throws RemoteException
    {
        return new SearchChangeMemberRmiService();
    }

    @Override
    public IShowCompetitionRmiService getShowCompetitionService() throws RemoteException
    {
        return new ShowCompetitionRmiService();
    }

    @Override
    public ILoginRmiService getLoginService() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 
    
}
