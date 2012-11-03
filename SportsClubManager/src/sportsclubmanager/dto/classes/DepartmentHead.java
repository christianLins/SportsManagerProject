package sportsclubmanager.dto.classes;

import sportsclubmanager.domain.contract.IDepartmentHead;
import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class DepartmentHead extends Role implements Serializable, IDepartmentHead {
    private List<Department> departmentList;
    private Role role;

    @Override
    public List<IDepartment> getDepartmentList()
    {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<IDepartment> departmentList)
    {
        this.departmentList = departmentList;
    }
}
