/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import classes.ShowCompetition;
import contract.ShowMatchObj;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IPlayer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rmi.contract.services.IShowCompetitionRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionRmiService extends UnicastRemoteObject implements IShowCompetitionRmiService
{
    
    public ShowCompetitionRmiService() throws RemoteException {
        super();
    }

    @Override
    public List<ICompetition> getCompetitions() throws RemoteException
    {
        return ShowCompetition.getInstance().getCompetitions();
    }

    @Override
    public List<IMatch> getMatchs(List<Integer> matches) throws RemoteException
    {
        return ShowCompetition.getInstance().getMatchs(matches);
    }

    @Override
    public List<ShowMatchObj> getTeams(List<Integer> matches) throws RemoteException
    {
        return ShowCompetition.getInstance().getTeams(matches);
    }

   

    @Override
    public List<IPlayer> getPlayer(IClubTeam team) throws RemoteException
    {
        return ShowCompetition.getInstance().getPlayer(team);
    }
    
}
