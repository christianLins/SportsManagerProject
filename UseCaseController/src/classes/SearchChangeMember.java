/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.*;
import java.util.List;
/**
 *
 * @author EnjoX
 */
public class SearchChangeMember implements ISearchChangeMember{
    
    private static SearchChangeMember INSTANCE;
    
    private SearchChangeMember() {
        
    }
    
    public static ISearchChangeMember getInstance() {
        if(INSTANCE == null) INSTANCE = new SearchChangeMember();
        return INSTANCE;
    }
    
    @Override
    public List<IMember> getMatchingMembers(String searchInput) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IMember getMember(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IRole getRoles(Integer memberId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IDepartment getDepartment(Integer memberId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IAddress getAddress(Integer addressId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ICountry getCountry(Integer countryID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<IDepartment> getDepartments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> clubTeams) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNewMember(IMember member, IAddress address) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
}
