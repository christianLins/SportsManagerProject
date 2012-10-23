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
@Table(name = "Greenkeeper")
@XmlRootElement
public class Greenkeeper extends Member1 implements Serializable
{
    private static final long serialVersionUID = 1L;
    //@Id
    //@Basic(optional = false)
    //@Column(name = "idMember")
    //private Integer idMember;
    @Basic(optional = false)
    @Column(name = "GreenkeeperFrom")
    @Temporal(TemporalType.DATE)
    private Date greenkeeperFrom;
    @Column(name = "GreenkeeperTo")
    @Temporal(TemporalType.DATE)
    private Date greenkeeperTo;
    //@JoinColumn(name = "idMember", referencedColumnName = "idMember", insertable = false, updatable = false)
    //@OneToOne(optional = false)
    //private Member1 member1;

    public Greenkeeper()
    {
    }

    /*public Greenkeeper(Integer idMember)
    {
        this.idMember = idMember;
    }*/

    public Greenkeeper(Integer idMember, Date greenkeeperFrom)
    {
        //this.idMember = idMember;
        this.greenkeeperFrom = greenkeeperFrom;
    }

    /*public Integer getIdMember()
    {
        return idMember;
    }

    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
    }*/

    public Date getGreenkeeperFrom()
    {
        return greenkeeperFrom;
    }

    public void setGreenkeeperFrom(Date greenkeeperFrom)
    {
        this.greenkeeperFrom = greenkeeperFrom;
    }

    public Date getGreenkeeperTo()
    {
        return greenkeeperTo;
    }

    public void setGreenkeeperTo(Date greenkeeperTo)
    {
        this.greenkeeperTo = greenkeeperTo;
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
        return "sportsclubmanager.domain.Greenkeeper[ idMember=" + super.getIdMember() + " ]";
    }
    
}
