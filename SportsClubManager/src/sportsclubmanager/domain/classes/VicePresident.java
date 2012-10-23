/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "VicePresident")
@XmlRootElement
public class VicePresident extends Member1 implements Serializable
{
    private static final long serialVersionUID = 1L;
    //@Id
    //@Basic(optional = false)
    //@Column(name = "idMember")
    //private Integer idMember;
    @Basic(optional = false)
    @Column(name = "VicePresidentFrom")
    @Temporal(TemporalType.DATE)
    private Date vicePresidentFrom;
    @Column(name = "VicePresidentTo")
    @Temporal(TemporalType.DATE)
    private Date vicePresidentTo;
    //@JoinColumn(name = "idMember", referencedColumnName = "idMember", insertable = false, updatable = false)
    //@OneToOne(optional = false)
    //private Member1 member1;

    public VicePresident()
    {
    }

    /*public VicePresident(Integer idMember)
    {
        this.idMember = idMember;
    }

    public VicePresident(Integer idMember, Date vicePresidentFrom)
    {
        this.idMember = idMember;
        this.vicePresidentFrom = vicePresidentFrom;
    }*/

    /*public Integer getIdMember()
    {
        return idMember;
    }

    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
    }*/

    public Date getVicePresidentFrom()
    {
        return vicePresidentFrom;
    }

    public void setVicePresidentFrom(Date vicePresidentFrom)
    {
        this.vicePresidentFrom = vicePresidentFrom;
    }

    public Date getVicePresidentTo()
    {
        return vicePresidentTo;
    }

    public void setVicePresidentTo(Date vicePresidentTo)
    {
        this.vicePresidentTo = vicePresidentTo;
    }

    /*public Member1 getMember1()
    {
        return member1;
    }

    public void setMember1(Member1 member1)
    {
        this.member1 = member1;
    }*/

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.VicePresident[ idMember=" + super.getIdMember() + " ]";
    }
    
}
