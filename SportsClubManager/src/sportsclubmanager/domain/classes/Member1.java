/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Member1 implements Serializable
{
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
    private String memberTo;
    @JoinColumn(name = "Address", referencedColumnName = "idAddress")
    @ManyToOne(optional = false)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member1")
    private Trainer trainer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member1")
    private Greenkeeper greenkeeper;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member1")
    private FinanceManager financeManager;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member1")
    private VicePresident vicePresident;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "member1")
    private President president;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headOfDepartment")
    private Collection<Department> departmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberidMember")
    private Collection<TeamMember> teamMemberCollection;

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

    public String getMemberTo()
    {
        return memberTo;
    }

    public void setMemberTo(String memberTo)
    {
        this.memberTo = memberTo;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Trainer getTrainer()
    {
        return trainer;
    }

    public void setTrainer(Trainer trainer)
    {
        this.trainer = trainer;
    }

    public Greenkeeper getGreenkeeper()
    {
        return greenkeeper;
    }

    public void setGreenkeeper(Greenkeeper greenkeeper)
    {
        this.greenkeeper = greenkeeper;
    }

    public FinanceManager getFinanceManager()
    {
        return financeManager;
    }

    public void setFinanceManager(FinanceManager financeManager)
    {
        this.financeManager = financeManager;
    }

    public VicePresident getVicePresident()
    {
        return vicePresident;
    }

    public void setVicePresident(VicePresident vicePresident)
    {
        this.vicePresident = vicePresident;
    }

    public President getPresident()
    {
        return president;
    }

    public void setPresident(President president)
    {
        this.president = president;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection()
    {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection)
    {
        this.departmentCollection = departmentCollection;
    }

    @XmlTransient
    public Collection<TeamMember> getTeamMemberCollection()
    {
        return teamMemberCollection;
    }

    public void setTeamMemberCollection(Collection<TeamMember> teamMemberCollection)
    {
        this.teamMemberCollection = teamMemberCollection;
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
        return "sportsclubmanager.domain.Member1[ idMember=" + idMember + " ]";
    }
    
}
