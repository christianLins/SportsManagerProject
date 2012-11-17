/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.INewMember;
import dto.contract.*;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.contract.services.INewMemberRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberServiceMapper implements RmiServiceToServiceMapper<INewMemberRmiService, INewMember>
{

    public INewMember getService(INewMemberRmiService rmiService)
    {
        
        NewMember n = new NewMember();
        n.setService(rmiService);
        return n;  
    }
    
    private static class NewMember implements INewMember {
        
        private INewMemberRmiService service;
        
        
        public void setService(INewMemberRmiService service) {
            this.service = service;
        }

        @Override
        public void setNewMember(IMember member, IAddress address)
        {
            try
            {
                service.setNewMember(member, address);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public List<IDepartment> getDepartments()
        {
            try
            {
                return service.getDepartments();
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IClubTeam> getClubTeams(List<Integer> clubTeams)
        {
            try
            {
                return service.getClubTeams(clubTeams);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role)
        {
            try
            {
                service.setNewMember(member, address, department, clubTeam, role);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public List<ITypeOfSport> getTypeOfSports(List<Integer> typOfSportsList) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
}
