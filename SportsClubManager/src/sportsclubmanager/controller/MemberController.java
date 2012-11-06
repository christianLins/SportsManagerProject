/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.List;
import java.util.logging.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.domain.contract.IMember;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class MemberController
        implements MemberService
{
    static MemberController singleton = null;

    private MemberController()
    {
    }

    public static MemberController getInstance()
    {
        if (singleton == null)
        {
            singleton = new MemberController();
        }

        return singleton;
    }

    @Override
    public IMember getMember(Integer id)
    {
        List<IMember> memberlist = DomainFacade.getAll(IMember.class);
        for (IMember m : memberlist)
        {
            if (m.getIdMember() == id)
            {
                return m;
            }
        }
        return null;
    }

    @Override
    public boolean createNewMember(IMember member)
    {
        if (member != null)
        {
            try
            {
                //member.setIdMember(getNextMemberId()); //hier Id Set beabsichtigt?
                DomainFacade.set(member);
                return true;
            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean changeMember(IMember changedMember)
    {
        if (changedMember != null)
        {
            try
            {
                DomainFacade.set(changedMember);
                return true;
            }
            catch (CouldNotSaveException ex)
            {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }

    Integer getNextMemberId()
    {
        Integer highest = 0;
        List<IMember> memberlist = DomainFacade.getAll(IMember.class);
        if (memberlist.isEmpty())
        {
            return 0;
        }

        for (IMember m : memberlist)
        {
            if (m.getIdMember() > highest)
            {
                highest = m.getIdMember();
            }
        }

        return highest++;
    }
}
