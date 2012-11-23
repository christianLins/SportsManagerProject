/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.INewMember;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**
 *
 * @author EnjoX
 */
public class NewMember
        implements INewMember {

    private static INewMember INSTANCE;

    private NewMember() {
    }

    public static INewMember getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NewMember();
        }
        return INSTANCE;
    }

    @Override
    public void setNewMember(IMember member, IAddress address) {
        try {
            Integer adressId = DtoFactory.getAddressMapper().set(address);
            member.setAddress(adressId);
            DtoFactory.getMemberMapper().set(member);
        } catch (RemoteException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IDepartment> getDepartments() {
        try {
            return DtoFactory.getDepartmentMapper().getAll();
        } catch (RemoteException | NotFoundException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> clubTeams) {
        List<IClubTeam> clubTeamList = new ArrayList<>();
        try {
            for (Integer team : clubTeams) {
                clubTeamList.add(DtoFactory.getClubTeamMapper().getById(team));
            }

        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubTeamList;
    }

    @Override
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) {
        try {
            //Muss noch geändert werden!!!!
            Integer roleId = DtoFactory.getRoleMapper().set(role);
            Integer adressId = DtoFactory.getAddressMapper().set(address);
            //Integer departmentId = DtoFactory.getDepartmentMapper().set(department);
            //Integer clubTeamId = DtoFactory.getClubTeamMapper().set(clubTeam);


            member.setAddress(adressId);
            List<Integer> roleList = member.getRoleList();
            roleList.add(roleId);
            member.setRoleList(roleList);

            Integer memberid = DtoFactory.getMemberMapper().set(member);

            //clubTeam.setPlayerList();
            //clubTeam.getPlayerList().
            //DtoFactory.getClubTeamMapper().set();
        } catch (RemoteException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITypeOfSport> getTypeOfSports(List<Integer> typOfSportsList) {
        List<ITypeOfSport> typeOfSportReturnList = new ArrayList<>();
        try {
            for (Integer sportID : typOfSportsList) {
                typeOfSportReturnList.add(DtoFactory.getTypeOfSportMapper().getById(sportID));

            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeOfSportReturnList;
    }

    @Override
    public List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport) {

        List<IClubTeam> ret = new LinkedList<>();
        try {
            ret = DtoFactory.getClubTeamMapper().getClubTeamsByTypeOfSport(sport);

        } catch (ClubTeamNotFoundException | RemoteException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
