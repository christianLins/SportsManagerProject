/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import classes.NewMember;
import dto.contract.*;
import java.rmi.RemoteException;
import java.util.List;
import rmi.contract.services.INewMemberRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewMemberRmiService implements INewMemberRmiService
{

    @Override
    public void setNewMember(IMember member, IAddress address) throws RemoteException
    {
        NewMember.getInstance().setNewMember(member, address);
    }

    @Override
    public List<IDepartment> getDepartments()
    {
        return NewMember.getInstance().getDepartments();
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> clubTeams) throws RemoteException
    {
        return NewMember.getInstance().getClubTeams(clubTeams);
    }

    @Override
    public void setNewMember(IMember member, IAddress address, IDepartment department, IClubTeam clubTeam, IRole role) throws RemoteException
    {
        NewMember.getInstance().setNewMember(member, address, department, clubTeam, role);
    }
    
}
