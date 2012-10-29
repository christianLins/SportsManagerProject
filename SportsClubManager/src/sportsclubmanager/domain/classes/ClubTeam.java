package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "ClubTeam")
@XmlRootElement
public class ClubTeam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTeam")
    private Integer idTeam;
    @ManyToMany(mappedBy = "clubTeamList")
    private List<Department> departmentList;
    @JoinTable(name = "Team_has_Trainer", joinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Trainer", referencedColumnName = "idTrainer")
    })
    @ManyToMany
    private List<Trainer> trainerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubTeam")
    private List<TeamhasPlayer> teamhasPlayerList;
    @JoinColumn(name = "idTeam", referencedColumnName = "idTeam", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Team team;

    public ClubTeam()
    {
    }

    public ClubTeam(Integer idTeam)
    {
        this.idTeam = idTeam;
    }

    public Integer getIdTeam()
    {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam)
    {
        this.idTeam = idTeam;
    }

    @XmlTransient
    public List<Department> getDepartmentList()
    {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList)
    {
        this.departmentList = departmentList;
    }

    @XmlTransient
    public List<Trainer> getTrainerList()
    {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList)
    {
        this.trainerList = trainerList;
    }

    @XmlTransient
    public List<TeamhasPlayer> getTeamhasPlayerList()
    {
        return teamhasPlayerList;
    }

    public void setTeamhasPlayerList(List<TeamhasPlayer> teamhasPlayerList)
    {
        this.teamhasPlayerList = teamhasPlayerList;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idTeam != null ? idTeam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClubTeam))
        {
            return false;
        }
        ClubTeam other = (ClubTeam) object;
        if ((this.idTeam == null && other.idTeam != null) || (this.idTeam != null && !this.idTeam.equals(other.idTeam)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.ClubTeam[ idTeam=" + idTeam + " ]";
    }

}
