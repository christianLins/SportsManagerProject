/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import java.rmi.RemoteException;
import dto.contract.*;
import services.ServiceClient;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClient implements ServiceClient
{
//    private IRmiServiceFactory factory;
//
//    public RmiServiceClient(IRmiServiceFactory factory)
//            throws CommunicationProblemException
//    {
//            this.factory = factory;
//    }

    public RmiServiceClient()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public contract.IAddMatchResults getAddMatchResultsService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public contract.IChangeCompetitionTeam getChangeCompetitionTeamService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public contract.INewCompetition getNewCompetitionService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public contract.INewMember getNewMemberService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public contract.ISearchChangeMember getSearchChangeMemberService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public contract.IShowCompetition getShowCompetitionService()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
