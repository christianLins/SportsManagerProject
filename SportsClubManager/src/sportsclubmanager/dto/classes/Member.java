package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Member
        implements Serializable, IMember
{
    private Integer idMember;
    private String prename;
    private String lastname;
    private Date dateOfBirth;
    private Date memberFrom;
    private Date memberTo;
    private String telephonenumber;
    private String emailAddress;
    private Boolean gender;
    private Country nationality;
    private Address address;
    private List<Role> roleList;

    @Override
    public Integer getIdMember()
    {
        return idMember;
    }

    @Override
    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
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
    public ICountry getNationality()
    {
        return nationality;
    }

    @Override
    public void setNationality(ICountry nationality)
    {
        this.nationality = Country.copy(nationality);
    }

    @Override
    public IAddress getAddress()
    {
        return address;
    }

    @Override
    public void setAddress(IAddress address)
    {
        this.address = Address.copy(address);
    }

    @Override
    public List<IRole> getRoleList()
    {
        List<IRole> result = new LinkedList<>();

        for (Role c : roleList)
        {
            result.add(c);
        }

        return result;
    }

    @Override
    public void setRoleList(List<IRole> roleList)
    {
        List<Role> result = new LinkedList<>();

        for (IRole c : roleList)
        {
            result.add(new Role(c));
        }

        this.roleList = result;
    }
}
