package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Permisssion")
@XmlRootElement
public class Permisssion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermisssion")
    private Integer idPermisssion;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @ManyToMany(mappedBy = "permisssionList")
    private List<Role> roleList;

    public Permisssion()
    {
    }

    public Permisssion(Integer idPermisssion)
    {
        this.idPermisssion = idPermisssion;
    }

    public Permisssion(Integer idPermisssion, String name)
    {
        this.idPermisssion = idPermisssion;
        this.name = name;
    }

    public Integer getIdPermisssion()
    {
        return idPermisssion;
    }

    public void setIdPermisssion(Integer idPermisssion)
    {
        this.idPermisssion = idPermisssion;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @XmlTransient
    public List<Role> getRoleList()
    {
        return roleList;
    }

    public void setRoleList(List<Role> roleList)
    {
        this.roleList = roleList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idPermisssion != null ? idPermisssion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisssion))
        {
            return false;
        }
        Permisssion other = (Permisssion) object;
        if ((this.idPermisssion == null && other.idPermisssion != null) || (this.idPermisssion != null && !this.idPermisssion.equals(other.idPermisssion)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Permisssion[ idPermisssion=" + idPermisssion + " ]";
    }

}
