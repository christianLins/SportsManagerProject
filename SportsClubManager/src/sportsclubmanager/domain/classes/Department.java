package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Department")
@XmlRootElement
public class Department implements Serializable {
    @JoinColumn(name = "DepartmentHead", referencedColumnName = "idRole")
    @ManyToOne(optional = false)
    private DepartmentHead departmentHead;
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
    @JoinTable(name = "Department_has_Team", joinColumns =
    {
        @JoinColumn(name = "Department", referencedColumnName = "idDepartment")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    })
    @ManyToMany
    private List<ClubTeam> clubTeamList;
    @JoinTable(name = "Department_has_TypeOfSport", joinColumns =
    {
        @JoinColumn(name = "Department", referencedColumnName = "idDepartment")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "TypeOfSport", referencedColumnName = "idTypeOfSport")
    })
    @ManyToMany
    private List<TypeOfSport> typeOfSports;

    public Department()
    {
    }

    public Department(Integer idDepartment)
    {
        this.idDepartment = idDepartment;
    }
    
    public Department(Integer idDepartment, String name)
    {
        this.idDepartment = idDepartment;
        this.name = name;
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

    @XmlTransient
    public List<ClubTeam> getClubTeamList()
    {
        return clubTeamList;
    }

    public void setClubTeamList(List<ClubTeam> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }

    @XmlTransient
    public List<TypeOfSport> geTypeOfSports()
    {
        return typeOfSports;
    }

    public void setTypeOfSports(List<TypeOfSport> typeOfSports)
    {
        this.typeOfSports = typeOfSports;
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
        return "sportsclubmanager.domain.classes.Department[ idDepartment=" + idDepartment + " ]";
    }

    public DepartmentHead getDepartmentHead()
    {
        return departmentHead;
    }

    public void setDepartmentHead(DepartmentHead departmentHead)
    {
        this.departmentHead = departmentHead;
    }

}
