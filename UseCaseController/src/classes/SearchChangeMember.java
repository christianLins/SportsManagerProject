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
public class SearchChangeMember implements ISearchChangeMember {

    private static SearchChangeMember INSTANCE;

    private SearchChangeMember() {
    }

    public static ISearchChangeMember getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SearchChangeMember();
        }
        return INSTANCE;
    }

    @Override
    public List<IMember> getMatchingMembers(String searchInput) {
        try {
            List<IMember> memberList = DtoFactory.getMemberManager().getAll();
            for (IMember member : memberList) {
            }
            return memberList;
        } catch (RemoteException | NotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IMember getMember(Integer id) {
        try {
            return DtoFactory.getMemberManager().getById(id);
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRole> getRoles(Integer memberId) {
        //RoleManager
        List<IRole> roleList = new ArrayList<>();
        try {
            IMember member = DtoFactory.getMemberManager().getById(memberId);
            for (Integer role : member.getRoleList()) {
                //RoleManager
                //roleList.add(null);
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleList;
    }

    @Override
    public IDepartment getDepartment(Integer memberId) {
        try {
            //Auch nicht wirklich korrekt!!!!
            List<IDepartment> depList = DtoFactory.getDepartmentManager().getAll();
            for (IDepartment dep : depList) {
                List<IClubTeam> clubList = new ArrayList<>();
                for (Integer club : dep.getClubTeamList()) {
                    clubList.add(DtoFactory.getClubTeamManager().getById(club));
                }

                for (IClubTeam team : clubList) {
                    if (team.getPlayerList().contains(memberId)) {
                        return dep;
                    }
                }
            }


        } catch (RemoteException | IdNotFoundException | NotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IAddress getAddress(Integer addressId) {
        try {
            return DtoFactory.getAddressManager().getById(addressId);
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICountry getCountry(Integer countryID) {
        try {
            DtoFactory.getCountryManager().getById(countryID);
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDepartment> getDepartments() {
        try {
            return DtoFactory.getDepartmentManager().getAll();
        } catch (RemoteException | NotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> clubTeams) {
        List<IClubTeam> teamList = new ArrayList<>();
        try {
            for (Integer team : clubTeams) {
                teamList.add(DtoFactory.getClubTeamManager().getById(team));
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamList;
    }

    @Override
    public void setNewMember(IMember member, IAddress address) {
        
       NewMember.getInstance().setNewMember(member, address);
    }

    @Override
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) {
        NewMember.getInstance().setNewMember(member, address, department, clubTeam, role);
    }
}
