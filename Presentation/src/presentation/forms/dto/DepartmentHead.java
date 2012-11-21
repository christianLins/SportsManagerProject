/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IDepartmentHead;
import java.util.List;

/**

 @author Thomas
 */
public class DepartmentHead
        extends Role
        implements IDepartmentHead
{
    List<Integer> departmentList;

    public DepartmentHead()
    {
    }

    public List<Integer> getDepartmentList()
    {
        return departmentList;
    }

    public void setDepartmentList(List<Integer> departmentList)
    {
        this.departmentList = departmentList;
    }
}
