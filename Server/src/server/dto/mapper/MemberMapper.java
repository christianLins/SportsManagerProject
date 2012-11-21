/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import domain.*;
import dto.classes.Member;
import dto.contract.IMember;
import dto.mapper.contract.*;
import java.util.*;
import java.util.logging.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class MemberMapper
        implements IMemberMapper
{
    private static MemberMapper controller;

    public MemberMapper()
    {
    }

    public static IMemberMapper getInstance()
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
        try
        {
            domain.contract.IMember a = DomainFacade.getInstance().getByID(domain.contract.IMember.class, id);
            return a;

        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IMember getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IMember a = DomainFacade.getInstance().getByID(domain.contract.IMember.class, id);
            return Member.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    public IMember getMemberByUsername(String username)
            throws NotFoundException
    {
        try
        {
            domain.contract.IMember a = DomainFacade.getInstance().getMemberByUsername(username);
            System.out.println(a);
            return Member.copy(a);
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public List<IMember> getAll()
            throws NotFoundException
    {
        try
        {
            List<IMember> result = new LinkedList<>();

            for (domain.contract.IMember a : DomainFacade.getInstance().getAll(domain.contract.IMember.class))
            {
                result.add(Member.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IMember value)
    {
        try
        {
            domain.classes.Member member = createDomain(value);

            return DomainFacade.getInstance().set(member);
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

            DomainFacade.getInstance().delete(member);
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

    @Override
    public IMember getNew()
    {
        return new Member();
    }
}
