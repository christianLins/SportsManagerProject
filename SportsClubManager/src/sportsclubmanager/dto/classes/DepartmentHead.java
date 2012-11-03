package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class DepartmentHead
        extends Role
        implements Serializable, IDepartmentHead
{
    private List<Department> departmentList = new LinkedList<>();

    public DepartmentHead()
    {
    }

    public DepartmentHead(IDepartmentHead d)
    {
        for (IDepartment c : d.getDepartmentList())
        {
            departmentList.add(new Department(c));
        }
    }

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
            result.add(new Department(d));
        }

        this.departmentList = result;
    }
}
