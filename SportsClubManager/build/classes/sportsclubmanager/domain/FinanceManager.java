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
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "FinanceManager")
@XmlRootElement
@Inheritance
public class FinanceManager extends Member1 implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMember")
    private Integer idMember;
    @Basic(optional = false)
    @Column(name = "FinanceManagerFrom")
    @Temporal(TemporalType.DATE)
    private Date financeManagerFrom;
    @Column(name = "FinanceManagerTo")
    @Temporal(TemporalType.DATE)
    private Date financeManagerTo;
    //@JoinColumn(name = "idMember", referencedColumnName = "idMember", insertable = false, updatable = false)
    //@OneToOne(optional = false)
    //private Member1 member1;

    public FinanceManager()
    {
    }

    public FinanceManager(Integer idMember)
    {
        this.idMember = idMember;
    }

    public FinanceManager(Integer idMember, Date financeManagerFrom)
    {
        this.idMember = idMember;
        this.financeManagerFrom = financeManagerFrom;
    }

    public Integer getIdMember()
    {
        return idMember;
    }

    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
    }

    public Date getFinanceManagerFrom()
    {
        return financeManagerFrom;
    }

    public void setFinanceManagerFrom(Date financeManagerFrom)
    {
        this.financeManagerFrom = financeManagerFrom;
    }

    public Date getFinanceManagerTo()
    {
        return financeManagerTo;
    }

    public void setFinanceManagerTo(Date financeManagerTo)
    {
        this.financeManagerTo = financeManagerTo;
    }

 /*   public Member1 getMember1()
    {
        return member1;
    }

    public void setMember1(Member1 member1)
    {
        this.member1 = member1;
    }*/

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
        if (!(object instanceof FinanceManager))
        {
            return false;
        }
        FinanceManager other = (FinanceManager) object;
        if ((this.idMember == null && other.idMember != null) || (this.idMember != null && !this.idMember.equals(other.idMember)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.FinanceManager[ idMember=" + idMember + " ]";
    }
    
}
