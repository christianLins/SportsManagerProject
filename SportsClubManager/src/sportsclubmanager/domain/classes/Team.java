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
@Table(name = "Team")
@XmlRootElement
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Team implements Serializable {
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
    @ManyToMany(mappedBy = "teamList")
    private List<Competition> competitionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foreignteam")
    private List<Match> matchList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hometeam")
    private List<Match> matchList1;
    @JoinColumn(name = "League", referencedColumnName = "idLeague")
    @ManyToOne(optional = false)
    private League league;

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
    public List<Competition> getCompetitionList()
    {
        return competitionList;
    }

    public void setCompetitionList(List<Competition> competitionList)
    {
        this.competitionList = competitionList;
    }

    @XmlTransient
    public List<Match> getMatchList()
    {
        return matchList;
    }

    public void setMatchList(List<Match> matchList)
    {
        this.matchList = matchList;
    }

    @XmlTransient
    public List<Match> getMatchList1()
    {
        return matchList1;
    }

    public void setMatchList1(List<Match> matchList1)
    {
        this.matchList1 = matchList1;
    }

    public League getLeague()
    {
        return league;
    }

    public void setLeague(League league)
    {
        this.league = league;
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
        return "sportsclubmanager.domain.classes.Team[ idTeam=" + idTeam + " ]";
    }

}
