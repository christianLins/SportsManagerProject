/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**

 @author Thomas
 */
public interface IDepartmentHead
        extends IDto, IRole
{
    List<Integer> getDepartmentList();

    void setDepartmentList(List<Integer> departmentList);
}
