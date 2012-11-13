/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import dto.contract.*;
import dto.mapper.contract.IMapper;
import java.rmi.RemoteException;

/**

 @author Thomas
 */
public class DtoFactory
{
    public static IMapper<IMember> getMemberMapper()
            throws RemoteException
    {
        return MemberMapper.getInstance();
    }

    public static IMapper<IRole> getRoleMapper()
            throws RemoteException
    {
        return RoleMapper.getInstance();
    }

    public static IMapper<ICompetition> getCompetitionMapper()
            throws RemoteException
    {
        return CompetitionMapper.getInstance();
    }

    public static IMapper<ICompetition> getCompetitionManager()
            throws RemoteException
    {
        return CompetitionMapper.getInstance();
    }

    public static IMapper<IMember> getMemberManager()
            throws RemoteException
    {
        return MemberMapper.getInstance();
    }

    public static IMapper<IAddress> getAddressManager()
            throws RemoteException
    {
        return AddressMapper.getInstance();
    }

    public static IMapper<IClubTeam> getClubTeamManager()
            throws RemoteException
    {
        return ClubTeamMapper.getInstance();
    }

    public static IMapper<ICountry> getCountryManager()
            throws RemoteException
    {
        return CountryMapper.getInstance();
    }

    public static IMapper<IDepartment> getDepartmentManager()
            throws RemoteException
    {
        return DepartmentMapper.getInstance();
    }

    public static IMapper<ITeam> getTeamManager()
            throws RemoteException
    {
        return TeamMapper.getInstance();
    }

    public static IMapper<ITypeOfSport> getTypeOfSportManager()
            throws RemoteException
    {
        return TypeOfSportMapper.getInstance();
    }

    public static IMapper<ITrainer> getTrainerManager()
            throws RemoteException
    {
        return TrainerMapper.getInstance();
    }

    public static IMapper<IDepartmentHead> getDepartmentHeadManager()
            throws RemoteException
    {
        return DepartmentHeadMapper.getInstance();
    }

    public static IMapper<ILeague> getLeagueManager()
            throws RemoteException
    {
        return LeagueMapper.getInstance();
    }

    public static IMapper<IPermission> getPermissionManager()
            throws RemoteException
    {
        return PermissionMapper.getInstance();
    }

    public static IMapper<IPlayer> getPlayerManager()
            throws RemoteException
    {
        return PlayerMapper.getInstance();
    }

    public static IMapper<IMatchresult> getMatchresultManager()
            throws RemoteException
    {
        return MatchresultMapper.getInstance();
    }

    public static IMapper<IMatch> getMatchManager()
            throws RemoteException
    {
        return MatchMapper.getInstance();
    }
}
