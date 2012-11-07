/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.DomainFacade;
import sportsclubmanager.dto.classes.Member;
import sportsclubmanager.dto.contract.IMember;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class MemberController
        implements IController<IMember>
{
    private static MemberController controller;

    public MemberController()
    {
    }

    public static IController<IMember> getInstance()
    {
        if (controller == null)
        {
            controller = new MemberController();
        }

        return controller;
    }

    @Override
    public IMember getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IMember a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMember.class))
        {
            if (a.getIdMember() == id)
            {
                return Member.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IMember> getAll()
    {
        List<IMember> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IMember a : DomainFacade.getAll(sportsclubmanager.domain.contract.IMember.class))
        {
            result.add(Member.copy(a));
        }

        return result;
    }

    @Override
    public void set(IMember value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
