/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.rmi.controller;

import contract.dto.*;
import contract.rmi.services.IShowCompetitionRmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.useCaseController.ShowCompetition;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ShowCompetitionRmiService
        extends UnicastRemoteObject
        implements IShowCompetitionRmiService
{
    public ShowCompetitionRmiService()
            throws RemoteException
    {
        super();
    }

    @Override
    public List<ICompetition> getCompetitions()
            throws RemoteException
    {
        return ShowCompetition.getInstance().getCompetitions();
    }

    @Override
    public List<IMatch> getMatchs(List<Integer> matches)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getMatchs(matches);
    }

    @Override
    public List<IPlayer> getPlayer(IClubTeam team)
            throws RemoteException
    {
        return ShowCompetition.getInstance().getPlayer(team);
    }
}
