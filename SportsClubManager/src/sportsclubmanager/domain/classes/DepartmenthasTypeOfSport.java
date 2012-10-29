package sportsclubmanager.domain.classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Department_has_TypeOfSport")
@XmlRootElement
public class DepartmenthasTypeOfSport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartmentTypeOfSport")
    private Integer idDepartmentTypeOfSport;
    @JoinColumn(name = "Department_idDepartment", referencedColumnName = "idDepartment")
    @ManyToOne(optional = false)
    private Department departmentidDepartment;
    @JoinColumn(name = "TypeOfSport", referencedColumnName = "idTypeOfSport")
    @ManyToOne(optional = false)
    private TypeOfSport typeOfSport;

    public DepartmenthasTypeOfSport()
    {
    }

    public DepartmenthasTypeOfSport(Integer idDepartmentTypeOfSport)
    {
        this.idDepartmentTypeOfSport = idDepartmentTypeOfSport;
    }

    public Integer getIdDepartmentTypeOfSport()
    {
        return idDepartmentTypeOfSport;
    }

    public void setIdDepartmentTypeOfSport(Integer idDepartmentTypeOfSport)
    {
        this.idDepartmentTypeOfSport = idDepartmentTypeOfSport;
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
        if (!(object instanceof DepartmenthasTypeOfSport))
        {
            return false;
        }
        DepartmenthasTypeOfSport other = (DepartmenthasTypeOfSport) object;
        if ((this.idDepartmentTypeOfSport == null && other.idDepartmentTypeOfSport != null) || (this.idDepartmentTypeOfSport != null && !this.idDepartmentTypeOfSport.equals(other.idDepartmentTypeOfSport)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.DepartmenthasTypeOfSport[ idDepartmentTypeOfSport=" + idDepartmentTypeOfSport + " ]";
    }

}
