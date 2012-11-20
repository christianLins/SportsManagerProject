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
            List<IMember> memberList = DtoFactory.getMemberMapper().getAll();
            for (IMember member : memberList) {
                if(member.getLastname().contains(searchInput) || member.getPrename().contains(searchInput)
                        || member.getUsername().contains(searchInput))
                {
                    memberList.add(member);
                }
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
            return DtoFactory.getMemberMapper().getById(id);
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRole> getRoles(Integer memberId) {
        //RoleMapper
        List<IRole> roleList = new ArrayList<>();
        try {
            IMember member = DtoFactory.getMemberMapper().getById(memberId);
            for (Integer role : member.getRoleList()) {
                roleList.add(DtoFactory.getRoleMapper().getById(role));
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
            List<IDepartment> depList = DtoFactory.getDepartmentMapper().getAll();
            for (IDepartment dep : depList) {
                List<IClubTeam> clubList = new ArrayList<>();
                for (Integer club : dep.getClubTeamList()) {
                    clubList.add(DtoFactory.getClubTeamMapper().getById(club));
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
            return DtoFactory.getAddressMapper().getById(addressId);
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICountry getCountry(Integer countryID) {
        try {
            DtoFactory.getCountryMapper().getById(countryID);
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(SearchChangeMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDepartment> getDepartments() {
        try {
            return DtoFactory.getDepartmentMapper().getAll();
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
                teamList.add(DtoFactory.getClubTeamMapper().getById(team));
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

    @Override
    public List<ITypeOfSport> getTypeOfSports(List<Integer> sportsList) {
        List<ITypeOfSport> typeOfSportReturnList = new ArrayList<>();
        try {
            for (Integer sportID : sportsList) {
                typeOfSportReturnList.add(DtoFactory.getTypeOfSportMapper().getById(sportID));

            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeOfSportReturnList;
    }
}
