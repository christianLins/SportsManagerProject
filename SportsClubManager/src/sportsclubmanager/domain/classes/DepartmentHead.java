package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import sportsclubmanager.domain.contract.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "DepartmentHead")
@XmlRootElement
public class DepartmentHead
        extends Role
        implements Serializable, IDepartmentHead
{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentHead")
    private List<Department> departmentList;
    private static final long serialVersionUID = 1L;

    public DepartmentHead()
    {
    }

    @XmlTransient
    @Override
    public List<IDepartment> getDepartmentList()
    {
        List<IDepartment> result = new LinkedList<>();

        for (Department d : departmentList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setDepartmentList(List<IDepartment> departmentList)
    {
        List<Department> result = new LinkedList<>();

        for (IDepartment d : departmentList)
        {
            result.add((Department) d);
        }

        this.departmentList = result;
    }
}
