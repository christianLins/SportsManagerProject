/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Team")
@XmlRootElement
public class Team implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTeam")
    private Integer idTeam;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @ManyToMany(mappedBy = "teamCollection")
    private Collection<Competition> competitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foreignteam")
    private Collection<Match> matchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hometeam")
    private Collection<Match> matchCollection1;
    @JoinColumn(name = "League", referencedColumnName = "idLeague")
    @ManyToOne(optional = false)
    private League league;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Collection<DepartmentTeam> departmentTeamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Collection<TeamhasTrainer> teamhasTrainerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Collection<TeamMember> teamMemberCollection;

    public Team()
    {
    }

    public Team(Integer idTeam)
    {
        this.idTeam = idTeam;
    }

    public Team(Integer idTeam, String name)
    {
        this.idTeam = idTeam;
        this.name = name;
    }

    public Integer getIdTeam()
    {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam)
    {
        this.idTeam = idTeam;
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
    public Collection<Competition> getCompetitionCollection()
    {
        return competitionCollection;
    }

    public void setCompetitionCollection(Collection<Competition> competitionCollection)
    {
        this.competitionCollection = competitionCollection;
    }

    @XmlTransient
    public Collection<Match> getMatchCollection()
    {
        return matchCollection;
    }

    public void setMatchCollection(Collection<Match> matchCollection)
    {
        this.matchCollection = matchCollection;
    }

    @XmlTransient
    public Collection<Match> getMatchCollection1()
    {
        return matchCollection1;
    }

    public void setMatchCollection1(Collection<Match> matchCollection1)
    {
        this.matchCollection1 = matchCollection1;
    }

    public League getLeague()
    {
        return league;
    }

    public void setLeague(League league)
    {
        this.league = league;
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
    public Collection<TeamhasTrainer> getTeamhasTrainerCollection()
    {
        return teamhasTrainerCollection;
    }

    public void setTeamhasTrainerCollection(Collection<TeamhasTrainer> teamhasTrainerCollection)
    {
        this.teamhasTrainerCollection = teamhasTrainerCollection;
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
        hash += (idTeam != null ? idTeam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team))
        {
            return false;
        }
        Team other = (Team) object;
        if ((this.idTeam == null && other.idTeam != null) || (this.idTeam != null && !this.idTeam.equals(other.idTeam)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.Team[ idTeam=" + idTeam + " ]";
    }
    
}
