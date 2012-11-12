/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.*;
import dto.mapper.DtoFactory;
import dto.mapper.contract.IdNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try
        {
            Integer adressId = DtoFactory.getAddressManager().set(address);
            member.setAddress(adressId);
            DtoFactory.getMemberManager().set(member);
        }
        catch(RemoteException ex)
        {
           Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }

    @Override
    public List<IDepartment> getDepartments() {
        try {
            return DtoFactory.getDepartmentManager().getAll();
        } catch (RemoteException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> clubTeams) {
        List<IClubTeam> clubTeamList = new ArrayList<>();      
        try
        {
            for(Integer team : clubTeams)
            {
                clubTeamList.add(DtoFactory.getClubTeamManager().getById(team));
            }
            
        }
        catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubTeamList;
    }

    @Override
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) {
        try
        {
            
            Integer adressId = DtoFactory.getAddressManager().set(address);
            Integer departmentId = DtoFactory.getDepartmentManager().set(department);
            Integer clubTeamId = DtoFactory.getClubTeamManager().set(clubTeam);
            
            member.setAddress(adressId);
            DtoFactory.getMemberManager().set(member);
        }
        catch(RemoteException ex)
        {
           Logger.getLogger(NewMember.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
}
