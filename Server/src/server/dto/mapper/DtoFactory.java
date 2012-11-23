/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.dto.mapper.ITypeOfSportMapper;
import contract.dto.mapper.IMemberMapper;
import contract.dto.mapper.IClubTeamMapper;
import contract.dto.mapper.IMapper;
import contract.dto.mapper.ILeagueMapper;
import contract.dto.IDepartmentDto;
import contract.dto.ICountryDto;
import contract.dto.IAddressDto;
import contract.dto.IMatchDto;
import contract.dto.ICompetitionDto;
import contract.dto.IPermissionDto;
import contract.dto.ITeamDto;
import contract.dto.IMatchresultDto;
import contract.dto.IRoleDto;
import contract.dto.ICaretakerDto;
import contract.dto.IAdminDto;
import contract.dto.IPlayerDto;
import contract.dto.IDepartmentHeadDto;
import contract.dto.ITrainerDto;
import java.rmi.RemoteException;

/**
 @author Thomas
 */
public class DtoFactory
{
    public static IMapper<IAdminDto> getAdminMapper()
            throws RemoteException
    {
        return AdminMapper.getInstance();
    }

    public static IMapper<ICaretakerDto> getCaretakerMapper()
            throws RemoteException
    {
        return CaretakerMapper.getInstance();
    }

    public static IMemberMapper getMemberMapper()
            throws RemoteException
    {
        return MemberMapper.getInstance();
    }

    public static IMapper<IRoleDto> getRoleMapper()
            throws RemoteException
    {
        return RoleMapper.getInstance();
    }

    public static IMapper<ICompetitionDto> getCompetitionMapper()
            throws RemoteException
    {
        return CompetitionMapper.getInstance();
    }

    public static IMapper<IAddressDto> getAddressMapper()
            throws RemoteException
    {
        return AddressMapper.getInstance();
    }

    public static IClubTeamMapper getClubTeamMapper()
            throws RemoteException
    {
        return ClubTeamMapper.getInstance();
    }

    public static IMapper<ICountryDto> getCountryMapper()
            throws RemoteException
    {
        return CountryMapper.getInstance();
    }

    public static IMapper<IDepartmentDto> getDepartmentMapper()
            throws RemoteException
    {
        return DepartmentMapper.getInstance();
    }

    public static IMapper<ITeamDto> getTeamMapper()
            throws RemoteException
    {
        return TeamMapper.getInstance();
    }

    public static ITypeOfSportMapper getTypeOfSportMapper()
            throws RemoteException
    {
        return TypeOfSportMapper.getInstance();
    }

    public static IMapper<ITrainerDto> getTrainerMapper()
            throws RemoteException
    {
        return TrainerMapper.getInstance();
    }

    public static IMapper<IDepartmentHeadDto> getDepartmentHeadMapper()
            throws RemoteException
    {
        return DepartmentHeadMapper.getInstance();
    }

    public static ILeagueMapper getLeagueMapper()
            throws RemoteException
    {
        return LeagueMapper.getInstance();
    }

    public static IMapper<IPermissionDto> getPermissionMapper()
            throws RemoteException
    {
        return PermissionMapper.getInstance();
    }

    public static IMapper<IPlayerDto> getPlayerMapper()
            throws RemoteException
    {
        return PlayerMapper.getInstance();
    }

    public static IMapper<IMatchresultDto> getMatchresultMapper()
            throws RemoteException
    {
        return MatchresultMapper.getInstance();
    }

    public static IMapper<IMatchDto> getMatchMapper()
            throws RemoteException
    {
        return MatchMapper.getInstance();
    }
}
