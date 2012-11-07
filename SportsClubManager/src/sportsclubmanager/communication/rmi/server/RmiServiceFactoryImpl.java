/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import sportsclubmanager.communication.rmi.contract.IRmiServiceFactory;
import sportsclubmanager.communication.rmi.server.controller.IRmiCompetitionController;
import sportsclubmanager.communication.rmi.server.controller.IRmiMemberController;
import sportsclubmanager.communication.rmi.server.controller.RmiCompetitionController;
import sportsclubmanager.communication.rmi.server.controller.RmiMemberController;
import sportsclubmanager.controller.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.dto.contract.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceFactoryImpl
        extends UnicastRemoteObject
        implements IRmiServiceFactory
{
    public RmiServiceFactoryImpl()
            throws RemoteException
    {
        super();
    }
        
    public IRmiMemberController getMemberController() throws RemoteException {
        return RmiMemberController.getInstance();
    }
    
    public IRmiCompetitionController getCompetitionController() throws RemoteException {
        return RmiCompetitionController.getInstance();
    }
    

    @Override
    public IController<ICompetition> getCompetitionManager()
            throws RemoteException
    {
        return CompetitionController.getInstance();
    }

    @Override
    public IController<IMember> getMemberManager()
            throws RemoteException
    {
        return MemberController.getInstance();
    }

    @Override
    public IController<IAddress> getAddressManager()
            throws RemoteException
    {
               return AddressController.getInstance();
    }

    @Override
    public IController<IClubTeam> getClubTeamManager()
            throws RemoteException
    {
               return ClubTeamController.getInstance();
    }

    @Override
    public IController<ICountry> getCountryManager()
            throws RemoteException
    {
             return CountryController.getInstance();
    }

    @Override
    public IController<IDepartment> getDepartmentManager()
            throws RemoteException
    {
             return DepartmentController.getInstance();
    }

    @Override
    public IController<ITeam> getTeamManager()
            throws RemoteException
    {
             return TeamController.getInstance();
    }

    @Override
    public IController<ITypeOfSport> getTypeOfSportManager()
            throws RemoteException
    {
             return TypeOfSportController.getInstance();
    }

    @Override
    public IController<ITrainer> getTrainerManager()
            throws RemoteException
    {
             return TrainerController.getInstance();
    }

    @Override
    public IController<IDepartmentHead> getDepartmentHeadManager()
            throws RemoteException
    {
             return DepartmentHeadController.getInstance();
    }

    @Override
    public IController<ILeague> getLeagueManager()
            throws RemoteException
    {
             return LeagueController.getInstance();
    }

    @Override
    public IController<IPermission> getPermissionManager()
            throws RemoteException
    {
             return PermissionController.getInstance();
    }

    @Override
    public IController<IPlayer> getPlayerManager()
            throws RemoteException
    {
             return PlayerController.getInstance();
    }

    @Override
    public IController<IMatchresult> getMatchresultManager()
            throws RemoteException
    {
             return MatchresultController.getInstance();
    }

    @Override
    public IController<IMatch> getMatchManager()
            throws RemoteException
    {
             return MatchController.getInstance();
    }
}
