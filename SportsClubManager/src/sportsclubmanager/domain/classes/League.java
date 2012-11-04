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
@Table(name = "League")
@XmlRootElement
public class League
        implements Serializable, ILeague
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLeague")
    private Integer idLeague;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private List<Team> teamList;

    public League()
    {
    }

    public League(Integer idLeague)
    {
        this.idLeague = idLeague;
    }

    public League(Integer idLeague, String name)
    {
        this.idLeague = idLeague;
        this.name = name;
    }

    public Integer getIdLeague()
    {
        return idLeague;
    }

    public void setIdLeague(Integer idLeague)
    {
        this.idLeague = idLeague;
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
    public List<ITeam> getTeamList()
    {
        List<ITeam> result = new LinkedList<>();

        for (Team d : teamList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setTeamList(List<ITeam> teamList)
    {
        List<Team> result = new LinkedList<>();

        for (ITeam d : teamList)
        {
            result.add((Team) d);
        }

        this.teamList = result;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idLeague != null ? idLeague.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof League))
        {
            return false;
        }
        League other = (League) object;
        if ((this.idLeague == null && other.idLeague != null) || (this.idLeague != null && !this.idLeague.equals(other.idLeague)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.League[ idLeague=" + idLeague + " ]";
    }
}
