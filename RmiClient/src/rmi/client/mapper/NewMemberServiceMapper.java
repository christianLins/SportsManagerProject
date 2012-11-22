/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.dto.*;
import contract.rmi.services.INewMemberRmiService;
import contract.useCaseController.INewMember;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberServiceMapper
        implements RmiServiceToServiceMapper<INewMemberRmiService, INewMember>
{
    @Override
    public INewMember getService(INewMemberRmiService rmiService)
    {

        NewMember n = new NewMember();
        n.setService(rmiService);
        return n;
    }

    private static class NewMember
            implements INewMember
    {
        private INewMemberRmiService service;

        public void setService(INewMemberRmiService service)
        {
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
        public List<ITypeOfSport> getTypeOfSports(List<Integer> typOfSportsList)
        {
            try
            {
                return service.getTypeOfSports(typOfSportsList);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IClubTeam> getClubTeamsByTypeOfSport(ITypeOfSport sport)
        {
            try
            {
                return service.getClubTeamsByTypeOfSport(sport);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
