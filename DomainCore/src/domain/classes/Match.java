package domain.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import domain.contract.*;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Match")
@XmlRootElement
public class Match implements Serializable, IMatch {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatch")
    private Integer idMatch;
    @Basic(optional = false)
    @Column(name = "DateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "Competition", referencedColumnName = "idCompetition")
    @ManyToOne(optional = false)
    private Competition competition;
    @JoinColumn(name = "Matchresult", referencedColumnName = "idMatchresult")
    @ManyToOne(optional = false)
    private Matchresult matchresult;
    @JoinColumn(name = "Foreignteam", referencedColumnName = "idTeam")
    @ManyToOne(optional = false)
    private Team foreignteam;
    @JoinColumn(name = "Hometeam", referencedColumnName = "idTeam")
    @ManyToOne(optional = false)
    private Team hometeam;

    public Match()
    {
    }

    public Match(Integer idMatch)
    {
        this.idMatch = idMatch;
    }

    public Match(Integer idMatch, Date dateFrom)
    {
        this.idMatch = idMatch;
        this.dateFrom = dateFrom;
    }

    public Integer getId()
    {
        return idMatch;
    }

    public void setId(Integer idMatch)
    {
        this.idMatch = idMatch;
    }

    @Override
    public Date getDateFrom()
    {
        return dateFrom;
    }

    @Override
    public void setDateFrom(Date dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    @Override
    public Date getDateTo()
    {
        return dateTo;
    }

    @Override
    public void setDateTo(Date dateTo)
    {
        this.dateTo = dateTo;
    }

    @Override
    public ICompetition getCompetition()
    {
        return (ICompetition)competition;
    }

    @Override
    public void setCompetition(ICompetition competition)
    {
        this.competition = (Competition)competition;
    }

    @Override
    public IMatchresult getMatchresult()
    {
        return matchresult;
    }

    @Override
    public void setMatchresult(IMatchresult matchresult)
    {
        this.matchresult = (Matchresult)matchresult;
    }

    @Override
    public ITeam getForeignteam()
    {
        return foreignteam;
    }

    @Override
    public void setForeignteam(ITeam foreignteam)
    {
        this.foreignteam = (Team)foreignteam;
    }

    @Override
    public ITeam getHometeam()
    {
        return hometeam;
    }

    @Override
    public void setHometeam(ITeam hometeam)
    {
        this.hometeam = (Team)hometeam;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idMatch != null ? idMatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match))
        {
            return false;
        }
        Match other = (Match) object;
        if ((this.idMatch == null && other.idMatch != null) || (this.idMatch != null && !this.idMatch.equals(other.idMatch)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Match[ idMatch=" + idMatch + " ]";
    }

}
