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
@Table(name = "DepartmentTypeOfSport")
@XmlRootElement
public class DepartmentTypeOfSport implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartmentTypeOfSport")
    private Integer idDepartmentTypeOfSport;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "Department_idDepartment", referencedColumnName = "idDepartment")
    @ManyToOne(optional = false)
    private Department departmentidDepartment;
    @JoinColumn(name = "TypeOfSport", referencedColumnName = "idTypeOfSport")
    @ManyToOne(optional = false)
    private TypeOfSport typeOfSport;

    public DepartmentTypeOfSport()
    {
    }

    public DepartmentTypeOfSport(Integer idDepartmentTypeOfSport)
    {
        this.idDepartmentTypeOfSport = idDepartmentTypeOfSport;
    }

    public DepartmentTypeOfSport(Integer idDepartmentTypeOfSport, Date dateFrom)
    {
        this.idDepartmentTypeOfSport = idDepartmentTypeOfSport;
        this.dateFrom = dateFrom;
    }

    public Integer getIdDepartmentTypeOfSport()
    {
        return idDepartmentTypeOfSport;
    }

    public void setIdDepartmentTypeOfSport(Integer idDepartmentTypeOfSport)
    {
        this.idDepartmentTypeOfSport = idDepartmentTypeOfSport;
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

    public Department getDepartmentidDepartment()
    {
        return departmentidDepartment;
    }

    public void setDepartmentidDepartment(Department departmentidDepartment)
    {
        this.departmentidDepartment = departmentidDepartment;
    }

    public TypeOfSport getTypeOfSport()
    {
        return typeOfSport;
    }

    public void setTypeOfSport(TypeOfSport typeOfSport)
    {
        this.typeOfSport = typeOfSport;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idDepartmentTypeOfSport != null ? idDepartmentTypeOfSport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentTypeOfSport))
        {
            return false;
        }
        DepartmentTypeOfSport other = (DepartmentTypeOfSport) object;
        if ((this.idDepartmentTypeOfSport == null && other.idDepartmentTypeOfSport != null) || (this.idDepartmentTypeOfSport != null && !this.idDepartmentTypeOfSport.equals(other.idDepartmentTypeOfSport)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.DepartmentTypeOfSport[ idDepartmentTypeOfSport=" + idDepartmentTypeOfSport + " ]";
    }
    
}
