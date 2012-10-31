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
@Table(name = "ClubTeam")
@XmlRootElement
public class ClubTeam extends Team implements Serializable {
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
        @JoinColumn(name = "Trainer", referencedColumnName = "idRole")
    })
    @ManyToMany
    private List<Trainer> trainerList;
    //rebuild table to member connection not role connection
    @JoinTable(name = "Team_Has_Player", joinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Player", referencedColumnName = "idRole")
    })
    @ManyToMany
    private List<Player> players;

    public ClubTeam()
    {
    }

    public ClubTeam(Integer idTeam)
    {
        this.idTeam = idTeam;
    }

    @XmlTransient
    public List<Player> getPlayers()
    {
        return players;
    }

    public void setPlayers(List<Player> players)
    {
        this.players = players;
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
