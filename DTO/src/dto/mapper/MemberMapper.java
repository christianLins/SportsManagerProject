/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Member;
import dto.contract.IMember;
import dto.mapper.contract.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class MemberMapper
        implements IMapper<IMember>
{
    private static MemberMapper controller;

    public MemberMapper()
    {
    }

    public static IMapper<IMember> getInstance()
    {
        if (controller == null)
        {
            controller = new MemberMapper();
        }

        return controller;
    }

    public domain.contract.IMember getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IMember a : DomainFacade.getAll(domain.contract.IMember.class))
        {
            if (a.getIdMember() == id)
            {
                return a;
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public IMember getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IMember a : DomainFacade.getAll(domain.contract.IMember.class))
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

        for (domain.contract.IMember a : DomainFacade.getAll(domain.contract.IMember.class))
        {
            result.add(Member.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(IMember value)
    {
        try
        {
            domain.classes.Member member = createDomain(value);

            return DomainFacade.set(member);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IMember value)
    {
        try
        {
            domain.classes.Member member = createDomain(value);

            DomainFacade.delete(member);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(MemberMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Member createDomain(IMember value)
            throws IdNotFoundException
    {
        domain.classes.Member member = new domain.classes.Member(value.getId());


        member.setDateOfBirth(value.getDateOfBirth());
        member.setEmailAddress(value.getEmailAddress());
        member.setGender(value.getGender());
        member.setLastname(value.getLastname());
        member.setMemberFrom(value.getMemberFrom());
        member.setMemberTo(value.getMemberTo());
        member.setPrename(value.getPrename());
        member.setTelephonenumber(value.getTelephonenumber());

        member.setAddress(new AddressMapper().getDomainById(value.getAddress()));
        member.setNationality(new CountryMapper().getDomainById(value.getNationality()));

        List< domain.contract.IRole> roleList = new LinkedList<>();

        for (int i : value.getRoleList())
        {
            //TODO 
        }

        member.setRoleList(roleList);

        return member;
    }
}
