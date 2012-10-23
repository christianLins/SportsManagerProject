/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Competition")
@XmlRootElement
public class Competition implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompetition")
    private Integer idCompetition;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinTable(name = "Competition_has_Team", joinColumns =
    {
        @JoinColumn(name = "Competition", referencedColumnName = "idCompetition")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    })
    @ManyToMany
    private Collection<Team> teamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private Collection<Match> matchCollection;

    public Competition()
    {
    }

    public Competition(Integer idCompetition)
    {
        this.idCompetition = idCompetition;
    }

    public Competition(Integer idCompetition, Date dateFrom)
    {
        this.idCompetition = idCompetition;
        this.dateFrom = dateFrom;
    }

    public Integer getIdCompetition()
    {
        return idCompetition;
    }

    public void setIdCompetition(Integer idCompetition)
    {
        this.idCompetition = idCompetition;
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

    @XmlTransient
    public Collection<Team> getTeamCollection()
    {
        return teamCollection;
    }

    public void setTeamCollection(Collection<Team> teamCollection)
    {
        this.teamCollection = teamCollection;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idCompetition != null ? idCompetition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competition))
        {
            return false;
        }
        Competition other = (Competition) object;
        if ((this.idCompetition == null && other.idCompetition != null) || (this.idCompetition != null && !this.idCompetition.equals(other.idCompetition)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.Competition[ idCompetition=" + idCompetition + " ]";
    }
    
}
