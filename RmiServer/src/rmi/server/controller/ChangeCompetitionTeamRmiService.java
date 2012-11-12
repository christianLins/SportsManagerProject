/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import classes.ChangeCompetitionTeam;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rmi.contract.services.IChangeCompetitionTeamRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ChangeCompetitionTeamRmiService extends UnicastRemoteObject implements IChangeCompetitionTeamRmiService
{
    public ChangeCompetitionTeamRmiService() throws RemoteException {
        super();
    }

    @Override
    public List<ICompetition> getCompetition()
    {
        return ChangeCompetitionTeam.getInstance().getCompetition();
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> teams)
    {
        return ChangeCompetitionTeam.getInstance().getClubTeams(teams);
    }

    @Override
    public void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam)
    {
        ChangeCompetitionTeam.getInstance().setCompetitonTeam(competition, oldTeam, newTeam);
    }
    
}
