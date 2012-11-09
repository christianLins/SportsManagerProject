/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import contract.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.contract.RmiServiceClient;

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
    public IAddMatchResults getAddMatchResultsService() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IChangeCompetitionTeam getChangeCompetitionTeamService() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INewCompetition getNewCompetitionService() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public INewMember getNewMemberService() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ISearchChangeMember getSearchChangeMemberService() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IShowCompetition getShowCompetitionService() throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
