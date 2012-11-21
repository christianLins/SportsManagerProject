/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.IMatch;
import contract.dto.ICompetition;
import contract.dto.ITeam;
import contract.dto.IMatchresult;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import contract.rmi.services.IAddMatchResultsRmiService;
import server.useCaseController.AddMatchResults;

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
