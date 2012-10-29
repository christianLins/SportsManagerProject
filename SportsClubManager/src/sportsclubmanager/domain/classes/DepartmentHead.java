package sportsclubmanager.domain.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "DepartmentHead")
@XmlRootElement
public class DepartmentHead extends Role implements Serializable {
    private static final long serialVersionUID = 1L;
//    @JoinColumn(name = "idDepartmentHead", referencedColumnName = "idRole", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Role role;

    public DepartmentHead()
    {
    }

//    public DepartmentHead(Integer idDepartmentHead)
//    {
//        this.idDepartmentHead = idDepartmentHead;
//    }
//
//    public Integer getIdDepartmentHead()
//    {
//        return idDepartmentHead;
//    }
//
//    public void setIdDepartmentHead(Integer idDepartmentHead)
//    {
//        this.idDepartmentHead = idDepartmentHead;
//    }
//
//    public Role getRole()
//    {
//        return role;
//    }
//
//    public void setRole(Role role)
//    {
//        this.role = role;
//    }
}
