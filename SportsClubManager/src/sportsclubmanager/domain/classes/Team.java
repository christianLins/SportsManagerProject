package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import sportsclubmanager.domain.contract.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Team")
@XmlRootElement
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Team
        implements Serializable, ITeam
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

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @XmlTransient
    @Override
    public List<ICompetition> getCompetitionList()
    {
        List<ICompetition> result = new LinkedList<>();

        for (Competition d : competitionList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setCompetitionList(List<ICompetition> competitionList)
    {
        List<Competition> result = new LinkedList<>();

        for (ICompetition d : competitionList)
        {
            result.add((Competition) d);
        }

        this.competitionList = result;
    }

    @XmlTransient
    @Override
    public List<IMatch> getMatchList()
    {
        List<IMatch> result = new LinkedList<>();

        for (Match d : matchList)
        {
            result.add(d);
        }

        return result;
    }

    public void setMatchList(List<IMatch> matchList)
    {
        List<Match> result = new LinkedList<>();

        for (IMatch d : matchList)
        {
            result.add((Match) d);
        }

        this.matchList = result;
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

    @Override
    public ILeague getLeague()
    {
        return league;
    }

    @Override
    public void setLeague(ILeague league)
    {
        this.league = (League) league;
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
