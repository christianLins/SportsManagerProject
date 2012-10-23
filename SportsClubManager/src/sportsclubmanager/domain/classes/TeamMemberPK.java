/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TeamMemberPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "idTeamMember")
    private int idTeamMember;
    @Basic(optional = false)
    @Column(name = "Team_idTeam")
    private int teamidTeam;

    public TeamMemberPK()
    {
    }

    public TeamMemberPK(int idTeamMember, int teamidTeam)
    {
        this.idTeamMember = idTeamMember;
        this.teamidTeam = teamidTeam;
    }

    public int getIdTeamMember()
    {
        return idTeamMember;
    }

    public void setIdTeamMember(int idTeamMember)
    {
        this.idTeamMember = idTeamMember;
    }

    public int getTeamidTeam()
    {
        return teamidTeam;
    }

    public void setTeamidTeam(int teamidTeam)
    {
        this.teamidTeam = teamidTeam;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) idTeamMember;
        hash += (int) teamidTeam;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMemberPK))
        {
            return false;
        }
        TeamMemberPK other = (TeamMemberPK) object;
        if (this.idTeamMember != other.idTeamMember)
        {
            return false;
        }
        if (this.teamidTeam != other.teamidTeam)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.TeamMemberPK[ idTeamMember=" + idTeamMember + ", teamidTeam=" + teamidTeam + " ]";
    }
    
}
