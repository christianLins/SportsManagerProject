/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "TeamMember")
@XmlRootElement
public class TeamMember implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeamMemberPK teamMemberPK;
    @Basic(optional = false)
    @Column(name = "TeamMemberFrom")
    @Temporal(TemporalType.DATE)
    private Date teamMemberFrom;
    @Column(name = "TeamMemberTo")
    @Temporal(TemporalType.DATE)
    private Date teamMemberTo;
    @Column(name = "TeamMembercol")
    private String teamMembercol;
    @JoinColumn(name = "Member_idMember", referencedColumnName = "idMember")
    @ManyToOne(optional = false)
    private Member1 memberidMember;
    @JoinColumn(name = "Team_idTeam", referencedColumnName = "idTeam", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Team team;

    public TeamMember()
    {
    }

    public TeamMember(TeamMemberPK teamMemberPK)
    {
        this.teamMemberPK = teamMemberPK;
    }

    public TeamMember(TeamMemberPK teamMemberPK, Date teamMemberFrom)
    {
        this.teamMemberPK = teamMemberPK;
        this.teamMemberFrom = teamMemberFrom;
    }

    public TeamMember(int idTeamMember, int teamidTeam)
    {
        this.teamMemberPK = new TeamMemberPK(idTeamMember, teamidTeam);
    }

    public TeamMemberPK getTeamMemberPK()
    {
        return teamMemberPK;
    }

    public void setTeamMemberPK(TeamMemberPK teamMemberPK)
    {
        this.teamMemberPK = teamMemberPK;
    }

    public Date getTeamMemberFrom()
    {
        return teamMemberFrom;
    }

    public void setTeamMemberFrom(Date teamMemberFrom)
    {
        this.teamMemberFrom = teamMemberFrom;
    }

    public Date getTeamMemberTo()
    {
        return teamMemberTo;
    }

    public void setTeamMemberTo(Date teamMemberTo)
    {
        this.teamMemberTo = teamMemberTo;
    }

    public String getTeamMembercol()
    {
        return teamMembercol;
    }

    public void setTeamMembercol(String teamMembercol)
    {
        this.teamMembercol = teamMembercol;
    }

    public Member1 getMemberidMember()
    {
        return memberidMember;
    }

    public void setMemberidMember(Member1 memberidMember)
    {
        this.memberidMember = memberidMember;
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
        hash += (teamMemberPK != null ? teamMemberPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamMember))
        {
            return false;
        }
        TeamMember other = (TeamMember) object;
        if ((this.teamMemberPK == null && other.teamMemberPK != null) || (this.teamMemberPK != null && !this.teamMemberPK.equals(other.teamMemberPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.TeamMember[ teamMemberPK=" + teamMemberPK + " ]";
    }
    
}
