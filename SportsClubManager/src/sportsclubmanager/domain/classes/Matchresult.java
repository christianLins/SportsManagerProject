package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import sportsclubmanager.domain.contract.IMatchresult;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Matchresult")
@XmlRootElement
public class Matchresult
        implements Serializable, IMatchresult
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMatchresult")
    private Integer idMatchresult;
    @Basic(optional = false)
    @Column(name = "PointsHometeam")
    private double pointsHometeam;
    @Basic(optional = false)
    @Column(name = "PointsForeignteam")
    private double pointsForeignteam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matchresult")
    private List<Match> matchList;

    public Matchresult()
    {
    }

    public Matchresult(Integer idMatchresult)
    {
        this.idMatchresult = idMatchresult;
    }

    public Matchresult(Integer idMatchresult, double pointsHometeam, double pointsForeignteam)
    {
        this.idMatchresult = idMatchresult;
        this.pointsHometeam = pointsHometeam;
        this.pointsForeignteam = pointsForeignteam;
    }

    public Integer getIdMatchresult()
    {
        return idMatchresult;
    }

    public void setIdMatchresult(Integer idMatchresult)
    {
        this.idMatchresult = idMatchresult;
    }

    @Override
    public double getPointsHometeam()
    {
        return pointsHometeam;
    }

    @Override
    public void setPointsHometeam(double pointsHometeam)
    {
        this.pointsHometeam = pointsHometeam;
    }

    @Override
    public double getPointsForeignteam()
    {
        return pointsForeignteam;
    }

    @Override
    public void setPointsForeignteam(double pointsForeignteam)
    {
        this.pointsForeignteam = pointsForeignteam;
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
        hash += (idMatchresult != null ? idMatchresult.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matchresult))
        {
            return false;
        }
        Matchresult other = (Matchresult) object;
        if ((this.idMatchresult == null && other.idMatchresult != null) || (this.idMatchresult != null && !this.idMatchresult.equals(other.idMatchresult)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Matchresult[ idMatchresult=" + idMatchresult + " ]";
    }
}
