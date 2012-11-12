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
import java.util.List;
import rmi.contract.services.IShowCompetitionRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionRmiService implements IShowCompetitionRmiService
{

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
    public IPlayer getPlayer(IClubTeam team) throws RemoteException
    {
        return (IPlayer) ShowCompetition.getInstance().getPlayer(team);
    }
    
}
