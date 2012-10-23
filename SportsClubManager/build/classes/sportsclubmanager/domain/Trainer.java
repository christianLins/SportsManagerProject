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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Trainer")
@XmlRootElement
public class Trainer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMember")
    private Integer idMember;
    @Basic(optional = false)
    @Column(name = "TrainerFrom")
    @Temporal(TemporalType.DATE)
    private Date trainerFrom;
    @Column(name = "TrainerTo")
    @Temporal(TemporalType.DATE)
    private Date trainerTo;
    @JoinColumn(name = "idMember", referencedColumnName = "idMember", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Member1 member1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    private Collection<TeamhasTrainer> teamhasTrainerCollection;

    public Trainer()
    {
    }

    public Trainer(Integer idMember)
    {
        this.idMember = idMember;
    }

    public Trainer(Integer idMember, Date trainerFrom)
    {
        this.idMember = idMember;
        this.trainerFrom = trainerFrom;
    }

    public Integer getIdMember()
    {
        return idMember;
    }

    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
    }

    public Date getTrainerFrom()
    {
        return trainerFrom;
    }

    public void setTrainerFrom(Date trainerFrom)
    {
        this.trainerFrom = trainerFrom;
    }

    public Date getTrainerTo()
    {
        return trainerTo;
    }

    public void setTrainerTo(Date trainerTo)
    {
        this.trainerTo = trainerTo;
    }

    public Member1 getMember1()
    {
        return member1;
    }

    public void setMember1(Member1 member1)
    {
        this.member1 = member1;
    }

    @XmlTransient
    public Collection<TeamhasTrainer> getTeamhasTrainerCollection()
    {
        return teamhasTrainerCollection;
    }

    public void setTeamhasTrainerCollection(Collection<TeamhasTrainer> teamhasTrainerCollection)
    {
        this.teamhasTrainerCollection = teamhasTrainerCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idMember != null ? idMember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer))
        {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.idMember == null && other.idMember != null) || (this.idMember != null && !this.idMember.equals(other.idMember)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.Trainer[ idMember=" + idMember + " ]";
    }
    
}
