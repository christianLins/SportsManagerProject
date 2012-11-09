/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract;

import java.rmi.RemoteException;
import dto.contract.*;
import java.rmi.Remote;
import services.ServiceClient;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface RmiServiceClient extends Remote
{
   

    public contract.IAddMatchResults getAddMatchResultsService()throws RemoteException;
    public contract.IChangeCompetitionTeam getChangeCompetitionTeamService()throws RemoteException;
    public contract.INewCompetition getNewCompetitionService()throws RemoteException;
    public contract.INewMember getNewMemberService()throws RemoteException;
    public contract.ISearchChangeMember getSearchChangeMemberService()throws RemoteException;
    public contract.IShowCompetition getShowCompetitionService()throws RemoteException;

}
