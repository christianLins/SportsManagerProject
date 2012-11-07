/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.controller;

import java.rmi.*;
import dto.contract.*;
import dto.controller.contract.*;

/**

 @author Thomas
 */
public class DtoFactory
{
    public static IController<IMember> getMemberController()
            throws RemoteException
    {
        return MemberController.getInstance();
    }

    public static IController<ICompetition> getCompetitionController()
            throws RemoteException
    {
        return CompetitionController.getInstance();
    }

    public static IController<ICompetition> getCompetitionManager()
            throws RemoteException
    {
        return CompetitionController.getInstance();
    }

    public static IController<IMember> getMemberManager()
            throws RemoteException
    {
        return MemberController.getInstance();
    }

    public static IController<IAddress> getAddressManager()
            throws RemoteException
    {
        return AddressController.getInstance();
    }

    public static IController<IClubTeam> getClubTeamManager()
            throws RemoteException
    {
        return ClubTeamController.getInstance();
    }

    public static IController<ICountry> getCountryManager()
            throws RemoteException
    {
        return CountryController.getInstance();
    }

    public static IController<IDepartment> getDepartmentManager()
            throws RemoteException
    {
        return DepartmentController.getInstance();
    }

    public static IController<ITeam> getTeamManager()
            throws RemoteException
    {
        return TeamController.getInstance();
    }

    public static IController<ITypeOfSport> getTypeOfSportManager()
            throws RemoteException
    {
        return TypeOfSportController.getInstance();
    }

    public static IController<ITrainer> getTrainerManager()
            throws RemoteException
    {
        return TrainerController.getInstance();
    }

    public static IController<IDepartmentHead> getDepartmentHeadManager()
            throws RemoteException
    {
        return DepartmentHeadController.getInstance();
    }

    public static IController<ILeague> getLeagueManager()
            throws RemoteException
    {
        return LeagueController.getInstance();
    }

    public static IController<IPermission> getPermissionManager()
            throws RemoteException
    {
        return PermissionController.getInstance();
    }

    public static IController<IPlayer> getPlayerManager()
            throws RemoteException
    {
        return PlayerController.getInstance();
    }

    public static IController<IMatchresult> getMatchresultManager()
            throws RemoteException
    {
        return MatchresultController.getInstance();
    }

    public static IController<IMatch> getMatchManager()
            throws RemoteException
    {
        return MatchController.getInstance();
    }
}
