/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import contract.*;
import dto.contract.*;
import dto.mapper.DtoFactory;
import dto.mapper.contract.IdNotFoundException;
import dto.mapper.contract.NotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EnjoX
 */
public class NewMember implements INewMember {

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
}
