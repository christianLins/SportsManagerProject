/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract;

import java.rmi.Remote;
import java.rmi.RemoteException;
import rmi.contract.services.*;

/**
 * this class provides the server-side services via rmi
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface RmiServiceClient extends Remote {

    public IAddMatchResultsRmiService getAddMatchResultsService() throws RemoteException;

    public IChangeCompetitionTeamRmiService getChangeCompetitionTeamService() throws RemoteException;

    public INewCompetitionRmiService getNewCompetitionService() throws RemoteException;

    public INewMemberRmiService getNewMemberService() throws RemoteException;

    public ISearchChangeMemberRmiService getSearchChangeMemberService() throws RemoteException;

    public IShowCompetitionRmiService getShowCompetitionService() throws RemoteException;

    ILoginService getLoginService() throws RemoteException;
}
