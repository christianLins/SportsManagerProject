package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
public class Competition implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Payment")
    private Double payment;
    @JoinTable(name = "Competition_has_Team", joinColumns =
    {
        @JoinColumn(name = "Competition", referencedColumnName = "idCompetition")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Team", referencedColumnName = "idTeam")
    })
    @ManyToMany
    private List<Team> teamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private List<Match> matchList;

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

    public Double getPayment()
    {
        return payment;
    }

    public void setPayment(Double payment)
    {
        this.payment = payment;
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

    @XmlTransient
    public List<Match> getMatchList()
    {
        return matchList;
    }

    public void setMatchList(List<Match> matchList)
    {
        this.matchList = matchList;
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
        return "sportsclubmanager.domain.classes.Competition[ idCompetition=" + idCompetition + " ]";
    }

}
