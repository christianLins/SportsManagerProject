/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

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
@Table(name = "Department")
@XmlRootElement
public class Department implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartment")
    private Integer idDepartment;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<DepartmentTeam> departmentTeamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentidDepartment")
    private Collection<DepartmentTypeOfSport> departmentTypeOfSportCollection;
    @JoinColumn(name = "HeadOfDepartment", referencedColumnName = "idMember")
    @ManyToOne(optional = false)
    private Member1 headOfDepartment;

    public Department()
    {
    }

    public Department(Integer idDepartment)
    {
        this.idDepartment = idDepartment;
    }

    public Department(Integer idDepartment, String name, Date dateFrom)
    {
        this.idDepartment = idDepartment;
        this.name = name;
        this.dateFrom = dateFrom;
    }

    public Integer getIdDepartment()
    {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment)
    {
        this.idDepartment = idDepartment;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo()
    {
        return dateTo;
    }

    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    @XmlTransient
    public Collection<DepartmentTeam> getDepartmentTeamCollection()
    {
        return departmentTeamCollection;
    }

    public void setDepartmentTeamCollection(Collection<DepartmentTeam> departmentTeamCollection)
    {
        this.departmentTeamCollection = departmentTeamCollection;
    }

    @XmlTransient
    public Collection<DepartmentTypeOfSport> getDepartmentTypeOfSportCollection()
    {
        return departmentTypeOfSportCollection;
    }

    public void setDepartmentTypeOfSportCollection(Collection<DepartmentTypeOfSport> departmentTypeOfSportCollection)
    {
        this.departmentTypeOfSportCollection = departmentTypeOfSportCollection;
    }

    public Member1 getHeadOfDepartment()
    {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Member1 headOfDepartment)
    {
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idDepartment != null ? idDepartment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department))
        {
            return false;
        }
        Department other = (Department) object;
        if ((this.idDepartment == null && other.idDepartment != null) || (this.idDepartment != null && !this.idDepartment.equals(other.idDepartment)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.Department[ idDepartment=" + idDepartment + " ]";
    }
    
}
