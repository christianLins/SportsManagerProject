/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.ISearchChangeMember;
import dto.contract.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import rmi.contract.services.ISearchChangeMemberRmiService;

/**
 @author Thomas
 */
public class SearchChangeMember
        implements ISearchChangeMember
{
    private ISearchChangeMemberRmiService service;

    public void setService(ISearchChangeMemberRmiService service)
    {
        this.service = service;
    }

    @Override
    public List<IMember> getMatchingMembers(String searchInput)
    {
        try
        {
            return service.getMatchingMembers(searchInput);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IMember getMember(Integer id)
    {
        try
        {
            return service.getMember(id);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IRole> getRoles(Integer memberId)
    {
        try
        {
            return service.getRoles(memberId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IDepartment getDepartment(Integer memberId)
    {
        try
        {
            return service.getDepartment(memberId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IAddress getAddress(Integer addressId)
    {
        try
        {
            return service.getAddress(addressId);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ICountry getCountry(Integer countryID)
    {
        try
        {
            return service.getCountry(countryID);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ITypeOfSport> getTypeOfSports(List<Integer> sportsList)
    {
        try
        {
            return service.getTypeOfSports(sportsList);
        }
        catch (RemoteException ex)
        {
            Logger.getLogger(SearchChangeMemberServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new LinkedList<>();
    }

    @Override
    public IMember getSelectedMember()
    {
        return service.getSelectedMember();
    }

    @Override
    public void setSelectedMember(IMember selectedMember)
    {
        service.setSelectedMember(selectedMember);
    }
}
