/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import classes.NewCompetition;
import dto.contract.ICompetition;
import dto.contract.IMember;
import dto.contract.ITeam;
import java.rmi.RemoteException;
import java.util.List;
import rmi.contract.services.INewCompetitionRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionRmiService implements INewCompetitionRmiService
{

    @Override
    public void setCompetition(ICompetition competition, IMember member) throws RemoteException
    {
        NewCompetition.getInstance().setCompetition(competition, member);
    }

    @Override
    public List<ITeam> getTeams() throws RemoteException
    {
        return NewCompetition.getInstance().getTeams();
    }
    
}
