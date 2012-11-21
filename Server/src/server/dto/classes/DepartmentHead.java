package server.dto.classes;

import contract.dto.IDepartmentHead;
import java.io.Serializable;
import java.util.*;

public class DepartmentHead
        extends Role
        implements Serializable, IDepartmentHead
{
    private List<Integer> departmentList = new LinkedList<>();
    private static HashMap<contract.domain.IDepartmentHead, DepartmentHead> departmentHeads = new HashMap<>();

    public static DepartmentHead copy(contract.domain.IDepartmentHead departmentHead)
    {
        DepartmentHead a;

        if (departmentHeads.containsKey(departmentHead))
        {
            a = departmentHeads.get(departmentHead);
        }
        else
        {
            a = copy(departmentHead, new DepartmentHead());

            List<Integer> l = new LinkedList<>();

            for (contract.domain.IDepartment t : departmentHead.getDepartmentList())
            {
                l.add(t.getId());
            }

            a.setDepartmentList(l);

            departmentHeads.put(departmentHead, a);
        }

        return a;
    }

    @Override
    public List<Integer> getDepartmentList()
    {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<Integer> departmentList)
    {
        this.departmentList = departmentList;
    }
}
