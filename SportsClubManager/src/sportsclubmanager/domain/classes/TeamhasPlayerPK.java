package sportsclubmanager.domain.classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Embeddable
public class TeamhasPlayerPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Team")
    private int team;
    @Basic(optional = false)
    @Column(name = "Player")
    private int player;

    public TeamhasPlayerPK()
    {
    }

    public TeamhasPlayerPK(int team, int player)
    {
        this.team = team;
        this.player = player;
    }

    public int getTeam()
    {
        return team;
    }

    public void setTeam(int team)
    {
        this.team = team;
    }

    public int getPlayer()
    {
        return player;
    }

    public void setPlayer(int player)
    {
        this.player = player;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) team;
        hash += (int) player;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamhasPlayerPK))
        {
            return false;
        }
        TeamhasPlayerPK other = (TeamhasPlayerPK) object;
        if (this.team != other.team)
        {
            return false;
        }
        if (this.player != other.player)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.TeamhasPlayerPK[ team=" + team + ", player=" + player + " ]";
    }

}
