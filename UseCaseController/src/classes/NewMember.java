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
public class NewMember implements INewMember{ 
    
    private static INewMember INSTANCE;
    
    private NewMember()  {
        
    }
    
    public static INewMember getInstance() {
        if(INSTANCE == null) INSTANCE = new NewMember();
        return INSTANCE;
    }
            
            

    @Override
    public void setNewMember(IMember member, IAddress address) {
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
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
