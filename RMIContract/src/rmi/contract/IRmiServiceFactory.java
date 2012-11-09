/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.contract;

import java.rmi.*;
import dto.mapper.contract.IMapper;
import dto.contract.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface IRmiServiceFactory
        extends Remote
{
    public IMapper<ICompetition> getCompetitionManager()
            throws RemoteException;

    public IMapper<IMember> getMemberManager()
            throws RemoteException;

    public IMapper<IAddress> getAddressManager()
            throws RemoteException;

    public IMapper<IClubTeam> getClubTeamManager()
            throws RemoteException;

    public IMapper<ICountry> getCountryManager()
            throws RemoteException;

    public IMapper<IDepartment> getDepartmentManager()
            throws RemoteException;

    public IMapper<ITeam> getTeamManager()
            throws RemoteException;

    public IMapper<ITypeOfSport> getTypeOfSportManager()
            throws RemoteException;

    public IMapper<ITrainer> getTrainerManager()
            throws RemoteException;

    public IMapper<IDepartmentHead> getDepartmentHeadManager()
            throws RemoteException;

    public IMapper<ILeague> getLeagueManager()
            throws RemoteException;

    public IMapper<IPermission> getPermissionManager()
            throws RemoteException;

    public IMapper<IPlayer> getPlayerManager()
            throws RemoteException;

    public IMapper<IMatchresult> getMatchresultManager()
            throws RemoteException;

    public IMapper<IMatch> getMatchManager()
            throws RemoteException;
}
