package sportsclubmanager.domain.classes;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Team_has_Player")
@XmlRootElement
public class TeamhasPlayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeamhasPlayerPK teamhasPlayerPK;
    @JoinColumn(name = "Team", referencedColumnName = "idTeam", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ClubTeam clubTeam;

    public TeamhasPlayer()
    {
    }

    public TeamhasPlayer(TeamhasPlayerPK teamhasPlayerPK)
    {
        this.teamhasPlayerPK = teamhasPlayerPK;
    }

    public TeamhasPlayer(int team, int player)
    {
        this.teamhasPlayerPK = new TeamhasPlayerPK(team, player);
    }

    public TeamhasPlayerPK getTeamhasPlayerPK()
    {
        return teamhasPlayerPK;
    }

    public void setTeamhasPlayerPK(TeamhasPlayerPK teamhasPlayerPK)
    {
        this.teamhasPlayerPK = teamhasPlayerPK;
    }

    public ClubTeam getClubTeam()
    {
        return clubTeam;
    }

    public void setClubTeam(ClubTeam clubTeam)
    {
        this.clubTeam = clubTeam;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (teamhasPlayerPK != null ? teamhasPlayerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamhasPlayer))
        {
            return false;
        }
        TeamhasPlayer other = (TeamhasPlayer) object;
        if ((this.teamhasPlayerPK == null && other.teamhasPlayerPK != null) || (this.teamhasPlayerPK != null && !this.teamhasPlayerPK.equals(other.teamhasPlayerPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.TeamhasPlayer[ teamhasPlayerPK=" + teamhasPlayerPK + " ]";
    }

}
