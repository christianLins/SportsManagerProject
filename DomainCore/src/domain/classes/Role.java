package domain.classes;

import domain.contract.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Role")
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
public class Role
        implements Serializable, IRole
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRole")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Role_has_Permission", joinColumns =
    {
        @JoinColumn(name = "Role_idRole")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Permission_idPermission")
    })
    private List<Permission> permissionList;
    @ManyToMany(mappedBy = "roleList")
    private List<Member> members;
    @Column(name="Description")
    private String description;

    public Role()
    {
    }

    public Role(Integer id)
    {
        this.id = id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
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
    public List<IPermission> getPermissionList()
    {
        List<IPermission> result = new LinkedList<>();

        for (Permission d : permissionList)
        {
            result.add((IPermission) d);
        }

        return result;
    }

    @Override
    public void setPermissionList(List<IPermission> permisssionList)
    {
        List<Permission> result = new LinkedList<>();

        for (IPermission d : permisssionList)
        {
            result.add((Permission) d);
        }

        this.permissionList = result;
    }

    @Override
    public List<IMember> getMembers()
    {
        if (members == null)
        {
            this.members = new LinkedList<>();
        }
        List<IMember> mem = new LinkedList<>();
        for (Member m : members)
        {
            mem.add(m);
        }
        return mem;
    }

    @Override
    public void setMembers(List<IMember> members)
    {
        for (IMember m : members)
        {
            this.members.add((Member) m);
        }
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
    public String getDesciption()
    {
        return this.description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }
}
