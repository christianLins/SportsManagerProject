/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "DepartmentTeam")
@XmlRootElement
public class DepartmentTeam implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartmentTeam")
    private Integer idDepartmentTeam;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    @ManyToOne(optional = false)
    private Team team;
    @JoinColumn(name = "Department", referencedColumnName = "idDepartment")
    @ManyToOne(optional = false)
    private Department department;

    public DepartmentTeam()
    {
    }

    public DepartmentTeam(Integer idDepartmentTeam)
    {
        this.idDepartmentTeam = idDepartmentTeam;
    }

    public DepartmentTeam(Integer idDepartmentTeam, Date dateFrom)
    {
        this.idDepartmentTeam = idDepartmentTeam;
        this.dateFrom = dateFrom;
    }

    public Integer getIdDepartmentTeam()
    {
        return idDepartmentTeam;
    }

    public void setIdDepartmentTeam(Integer idDepartmentTeam)
    {
        this.idDepartmentTeam = idDepartmentTeam;
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

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idDepartmentTeam != null ? idDepartmentTeam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentTeam))
        {
            return false;
        }
        DepartmentTeam other = (DepartmentTeam) object;
        if ((this.idDepartmentTeam == null && other.idDepartmentTeam != null) || (this.idDepartmentTeam != null && !this.idDepartmentTeam.equals(other.idDepartmentTeam)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.DepartmentTeam[ idDepartmentTeam=" + idDepartmentTeam + " ]";
    }
    
}
