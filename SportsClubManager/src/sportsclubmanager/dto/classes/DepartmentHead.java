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
    private static HashMap<IDepartmentHead, DepartmentHead> departmentHeads = new HashMap<>();

    public static DepartmentHead copy(IDepartmentHead departmentHead)
    {
        DepartmentHead a;

        if (departmentHeads.containsKey(departmentHead))
        {
            a = departmentHeads.get(departmentHead);
        }
        else
        {
            a = new DepartmentHead();

            a.setDepartmentList(departmentHead.getDepartmentList());

            departmentHeads.put(departmentHead, a);
        }

        return a;
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
            result.add(Department.copy(d));
        }

        this.departmentList = result;
    }
}
