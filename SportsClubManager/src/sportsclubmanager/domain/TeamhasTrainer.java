/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Team_has_Trainer")
@XmlRootElement
public class TeamhasTrainer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTeamTrainer")
    private Integer idTeamTrainer;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "Trainer", referencedColumnName = "idMember")
    @ManyToOne(optional = false)
    private Trainer trainer;
    @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    @ManyToOne(optional = false)
    private Team team;

    public TeamhasTrainer()
    {
    }

    public TeamhasTrainer(Integer idTeamTrainer)
    {
        this.idTeamTrainer = idTeamTrainer;
    }

    public TeamhasTrainer(Integer idTeamTrainer, Date dateFrom)
    {
        this.idTeamTrainer = idTeamTrainer;
        this.dateFrom = dateFrom;
    }

    public Integer getIdTeamTrainer()
    {
        return idTeamTrainer;
    }

    public void setIdTeamTrainer(Integer idTeamTrainer)
    {
        this.idTeamTrainer = idTeamTrainer;
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

    public Trainer getTrainer()
    {
        return trainer;
    }

    public void setTrainer(Trainer trainer)
    {
        this.trainer = trainer;
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
        hash += (idTeamTrainer != null ? idTeamTrainer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamhasTrainer))
        {
            return false;
        }
        TeamhasTrainer other = (TeamhasTrainer) object;
        if ((this.idTeamTrainer == null && other.idTeamTrainer != null) || (this.idTeamTrainer != null && !this.idTeamTrainer.equals(other.idTeamTrainer)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.TeamhasTrainer[ idTeamTrainer=" + idTeamTrainer + " ]";
    }
    
}
