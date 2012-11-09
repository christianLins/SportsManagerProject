/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import dto.mapper.TeamMapper;
import dto.mapper.CompetitionMapper;
import dto.mapper.DepartmentMapper;
import dto.mapper.AddressMapper;
import dto.mapper.TypeOfSportMapper;
import dto.mapper.CountryMapper;
import dto.mapper.ClubTeamMapper;
import dto.mapper.PlayerMapper;
import dto.mapper.MatchresultMapper;
import dto.mapper.TrainerMapper;
import dto.mapper.MemberMapper;
import dto.mapper.LeagueMapper;
import dto.mapper.DepartmentHeadMapper;
import dto.mapper.MatchMapper;
import dto.mapper.PermissionMapper;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.contract.IRmiServiceFactory;
import rmi.server.controller.*;
import dto.contract.*;
import dto.mapper.contract.IMapper;

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
    public IMapper<ICompetition> getCompetitionManager()
            throws RemoteException
    {
        return CompetitionMapper.getInstance();
    }

    @Override
    public IMapper<IMember> getMemberManager()
            throws RemoteException
    {
        return MemberMapper.getInstance();
    }

    @Override
    public IMapper<IAddress> getAddressManager()
            throws RemoteException
    {
        return AddressMapper.getInstance();
    }

    @Override
    public IMapper<IClubTeam> getClubTeamManager()
            throws RemoteException
    {
        return ClubTeamMapper.getInstance();
    }

    @Override
    public IMapper<ICountry> getCountryManager()
            throws RemoteException
    {
        return CountryMapper.getInstance();
    }

    @Override
    public IMapper<IDepartment> getDepartmentManager()
            throws RemoteException
    {
        return DepartmentMapper.getInstance();
    }

    @Override
    public IMapper<ITeam> getTeamManager()
            throws RemoteException
    {
        return TeamMapper.getInstance();
    }

    @Override
    public IMapper<ITypeOfSport> getTypeOfSportManager()
            throws RemoteException
    {
        return TypeOfSportMapper.getInstance();
    }

    @Override
    public IMapper<ITrainer> getTrainerManager()
            throws RemoteException
    {
        return TrainerMapper.getInstance();
    }

    @Override
    public IMapper<IDepartmentHead> getDepartmentHeadManager()
            throws RemoteException
    {
        return DepartmentHeadMapper.getInstance();
    }

    @Override
    public IMapper<ILeague> getLeagueManager()
            throws RemoteException
    {
        return LeagueMapper.getInstance();
    }

    @Override
    public IMapper<IPermission> getPermissionManager()
            throws RemoteException
    {
        return PermissionMapper.getInstance();
    }

    @Override
    public IMapper<IPlayer> getPlayerManager()
            throws RemoteException
    {
        return PlayerMapper.getInstance();
    }

    @Override
    public IMapper<IMatchresult> getMatchresultManager()
            throws RemoteException
    {
        return MatchresultMapper.getInstance();
    }

    @Override
    public IMapper<IMatch> getMatchManager()
            throws RemoteException
    {
        return MatchMapper.getInstance();
    }
}
