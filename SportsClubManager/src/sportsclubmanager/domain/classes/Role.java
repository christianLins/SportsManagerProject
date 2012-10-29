package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Role")
@XmlRootElement
@Inheritance
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRole")
    private Integer idRole;
    @JoinTable(name = "Role_has_Permisssion", joinColumns =
    {
        @JoinColumn(name = "Role_idRole", referencedColumnName = "idRole")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Permisssion_idPermisssion", referencedColumnName = "idPermisssion")
    })
    @ManyToMany
    private List<Permisssion> permisssionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "role")
    private Player player;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "role")
    private Trainer trainer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "role")
    private DepartmentHead departmentHead;
    @JoinColumn(name = "Member_idMember", referencedColumnName = "idMember")
    @ManyToOne(optional = false)
    private Member1 memberidMember;

    public Role()
    {
    }

    public Role(Integer idRole)
    {
        this.idRole = idRole;
    }

    public Integer getIdRole()
    {
        return idRole;
    }

    public void setIdRole(Integer idRole)
    {
        this.idRole = idRole;
    }

    @XmlTransient
    public List<Permisssion> getPermisssionList()
    {
        return permisssionList;
    }

    public void setPermisssionList(List<Permisssion> permisssionList)
    {
        this.permisssionList = permisssionList;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Trainer getTrainer()
    {
        return trainer;
    }

    public void setTrainer(Trainer trainer)
    {
        this.trainer = trainer;
    }

    public DepartmentHead getDepartmentHead()
    {
        return departmentHead;
    }

    public void setDepartmentHead(DepartmentHead departmentHead)
    {
        this.departmentHead = departmentHead;
    }

    public Member1 getMemberidMember()
    {
        return memberidMember;
    }

    public void setMemberidMember(Member1 memberidMember)
    {
        this.memberidMember = memberidMember;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
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
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Role[ idRole=" + idRole + " ]";
    }

}
