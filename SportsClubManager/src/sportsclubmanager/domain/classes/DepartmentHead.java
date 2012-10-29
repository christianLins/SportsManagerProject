package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "DepartmentHead")
@XmlRootElement
public class DepartmentHead extends Role implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentHead")
    private List<Department> departmentList;
    @JoinColumn(name = "idDepartmentHead", referencedColumnName = "idRole", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Role role;
    private static final long serialVersionUID = 1L;

    public DepartmentHead()
    {
    }

    @XmlTransient
    public List<Department> getDepartmentList()
    {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList)
    {
        this.departmentList = departmentList;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}
