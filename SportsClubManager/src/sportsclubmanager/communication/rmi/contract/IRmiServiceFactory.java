/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.contract;

import java.rmi.*;
import sportsclubmanager.dto.controller.contract.IController;
import sportsclubmanager.dto.contract.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface IRmiServiceFactory
        extends Remote
{
    public IController<ICompetition> getCompetitionManager()
            throws RemoteException;

    public IController<IMember> getMemberManager()
            throws RemoteException;

    public IController<IAddress> getAddressManager()
            throws RemoteException;

    public IController<IClubTeam> getClubTeamManager()
            throws RemoteException;

    public IController<ICountry> getCountryManager()
            throws RemoteException;

    public IController<IDepartment> getDepartmentManager()
            throws RemoteException;

    public IController<ITeam> getTeamManager()
            throws RemoteException;

    public IController<ITypeOfSport> getTypeOfSportManager()
            throws RemoteException;

    public IController<ITrainer> getTrainerManager()
            throws RemoteException;

    public IController<IDepartmentHead> getDepartmentHeadManager()
            throws RemoteException;

    public IController<ILeague> getLeagueManager()
            throws RemoteException;

    public IController<IPermission> getPermissionManager()
            throws RemoteException;

    public IController<IPlayer> getPlayerManager()
            throws RemoteException;

    public IController<IMatchresult> getMatchresultManager()
            throws RemoteException;

    public IController<IMatch> getMatchManager()
            throws RemoteException;
}
