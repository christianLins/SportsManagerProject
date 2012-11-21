/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import classes.AddMatchResults;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IMatchresult;
import dto.contract.ITeam;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rmi.contract.services.IAddMatchResultsRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class AddMatchResultsRmiService extends UnicastRemoteObject implements IAddMatchResultsRmiService
{
    
    public AddMatchResultsRmiService() throws RemoteException {
        super();
    }
    

    @Override
    public List<ICompetition> getCompetitionList() throws RemoteException
    {
        return AddMatchResults.getInstance().getCompetitionList();
    }

    @Override
    public List<ITeam> getTeamList(List<Integer> team) throws RemoteException
    {
         return AddMatchResults.getInstance().getTeamList(team);
    }

    @Override
    public List<IMatch> getMatchList(List<Integer> match) throws RemoteException
    {
         return AddMatchResults.getInstance().getMatchList(match);
    }

    @Override
    public void setMatchResult(IMatch match, IMatchresult matchresult) throws RemoteException
    {
         AddMatchResults.getInstance().setMatchResult(match, matchresult);
    }
    
}
