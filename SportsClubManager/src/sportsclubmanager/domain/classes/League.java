package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "League")
@XmlRootElement
public class League implements Serializable {
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
    public List<Team> getTeamList()
    {
        return teamList;
    }

    public void setTeamList(List<Team> teamList)
    {
        this.teamList = teamList;
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
