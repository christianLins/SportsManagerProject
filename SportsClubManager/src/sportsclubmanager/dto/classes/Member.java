package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.dto.contract.IMember;

public class Member
        implements Serializable, IMember
{
    private static HashMap<sportsclubmanager.domain.contract.IMember, Member> members = new HashMap<>();

    Member()
    {
        
    }
    
    public static IMember copy(sportsclubmanager.domain.contract.IMember member)
    {
        Member a;

        if (members.containsKey(member))
        {
            a = members.get(member);
        }
        else
        {
            a = new Member();

            a.setId(member.getIdMember());
            a.setPrename(member.getPrename());
            a.setLastname(member.getLastname());

            a.setDateOfBirth(member.getDateOfBirth());
            a.setMemberFrom(member.getMemberFrom());
            a.setMemberTo(member.getMemberTo());

            a.setTelephonenumber(member.getTelephonenumber());
            a.setEmailAddress(member.getEmailAddress());
            a.setGender(member.getGender());
            a.setNationality(member.getNationality().getId());
            a.setAddress(member.getAddress().getId());

            for (sportsclubmanager.domain.contract.IRole c : member.getRoleList())
            {
                a.roleList.add(c.getId());
            }
        }

        return a;
    }
    private Integer id;
    private String prename;
    private String lastname;
    private Date dateOfBirth;
    private Date memberFrom;
    private Date memberTo;
    private String telephonenumber;
    private String emailAddress;
    private Boolean gender;
    private Integer nationality;
    private Integer address;
    private List<Integer> roleList = new LinkedList<>();

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public void setId(Integer idMember)
    {
        this.id = idMember;
    }

    @Override
    public String getPrename()
    {
        return prename;
    }

    @Override
    public void setPrename(String prename)
    {
        this.prename = prename;
    }

    @Override
    public String getLastname()
    {
        return lastname;
    }

    @Override
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    @Override
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Date getMemberFrom()
    {
        return memberFrom;
    }

    @Override
    public void setMemberFrom(Date memberFrom)
    {
        this.memberFrom = memberFrom;
    }

    @Override
    public Date getMemberTo()
    {
        return memberTo;
    }

    @Override
    public void setMemberTo(Date memberTo)
    {
        this.memberTo = memberTo;
    }

    @Override
    public String getTelephonenumber()
    {
        return telephonenumber;
    }

    @Override
    public void setTelephonenumber(String telephonenumber)
    {
        this.telephonenumber = telephonenumber;
    }

    @Override
    public String getEmailAddress()
    {
        return emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    @Override
    public Boolean getGender()
    {
        return gender;
    }

    @Override
    public void setGender(Boolean gender)
    {
        this.gender = gender;
    }

    @Override
    public Integer getNationality()
    {
        return nationality;
    }

    @Override
    public void setNationality(Integer nationality)
    {
        this.nationality = nationality;
    }

    @Override
    public Integer getAddress()
    {
        return address;
    }

    @Override
    public void setAddress(Integer address)
    {
        this.address = address;
    }

    @Override
    public List<Integer> getRoleList()
    {
        return roleList;
    }

    @Override
    public void setRoleList(List<Integer> roleList)
    {
        this.roleList = roleList;
    }
}
