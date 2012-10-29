package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Member")
@XmlRootElement
public class Member1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMember")
    private Integer idMember;
    @Basic(optional = false)
    @Column(name = "Prename")
    private String prename;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "DateOfBirth")
    private String dateOfBirth;
    @Basic(optional = false)
    @Column(name = "MemberFrom")
    @Temporal(TemporalType.DATE)
    private Date memberFrom;
    @Column(name = "MemberTo")
    @Temporal(TemporalType.DATE)
    private Date memberTo;
    @Column(name = "Telephonenumber")
    private String telephonenumber;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "Gender")
    private Boolean gender;
    @JoinColumn(name = "Nationality", referencedColumnName = "idCountry")
    @ManyToOne(optional = false)
    private Country nationality;
    @JoinColumn(name = "Address", referencedColumnName = "idAddress")
    @ManyToOne(optional = false)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberidMember")
    private List<Role> roleList;

    public Member1()
    {
    }

    public Member1(Integer idMember)
    {
        this.idMember = idMember;
    }

    public Member1(Integer idMember, String prename, String lastname, String dateOfBirth, Date memberFrom)
    {
        this.idMember = idMember;
        this.prename = prename;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.memberFrom = memberFrom;
    }

    public Integer getIdMember()
    {
        return idMember;
    }

    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
    }

    public String getPrename()
    {
        return prename;
    }

    public void setPrename(String prename)
    {
        this.prename = prename;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getMemberFrom()
    {
        return memberFrom;
    }

    public void setMemberFrom(Date memberFrom)
    {
        this.memberFrom = memberFrom;
    }

    public Date getMemberTo()
    {
        return memberTo;
    }

    public void setMemberTo(Date memberTo)
    {
        this.memberTo = memberTo;
    }

    public String getTelephonenumber()
    {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber)
    {
        this.telephonenumber = telephonenumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public Boolean getGender()
    {
        return gender;
    }

    public void setGender(Boolean gender)
    {
        this.gender = gender;
    }

    public Country getNationality()
    {
        return nationality;
    }

    public void setNationality(Country nationality)
    {
        this.nationality = nationality;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @XmlTransient
    public List<Role> getRoleList()
    {
        return roleList;
    }

    public void setRoleList(List<Role> roleList)
    {
        this.roleList = roleList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idMember != null ? idMember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1))
        {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.idMember == null && other.idMember != null) || (this.idMember != null && !this.idMember.equals(other.idMember)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Member1[ idMember=" + idMember + " ]";
    }

}
