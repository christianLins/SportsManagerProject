package domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import domain.contract.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Role1")
@XmlRootElement
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Role
        implements Serializable, IRole
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRole")
    private Integer id;
    @JoinTable(name = "Role_has_Permisssion", joinColumns =
    {
        @JoinColumn(name = "Role_idRole", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Permisssion_idPermisssion", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Permission> permisssionList;
    @JoinColumn(name = "Member_idMember", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member memberidMember;

    public Role()
    {
    }

    public Role(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @XmlTransient
    @Override
    public List<IPermission> getPermisssionList()
    {
        List<IPermission> result = new LinkedList<>();

        for (Permission d : permisssionList)
        {
            result.add((IPermission)d);
        }

        return result;
    }

    @Override
    public void setPermisssionList(List<IPermission> permisssionList)
    {
        List<Permission> result = new LinkedList<>();

        for (IPermission d : permisssionList)
        {
            result.add((Permission) d);
        }

        this.permisssionList = result;
    }

    public Member getMemberidMember()
    {
        return memberidMember;
    }

    public void setMemberidMember(Member memberidMember)
    {
        this.memberidMember = memberidMember;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role))
        {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Role[ id=" + id + " ]";
    }
}
