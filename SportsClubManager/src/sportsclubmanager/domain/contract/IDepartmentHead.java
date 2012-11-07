/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface IDepartmentHead extends IRole
{
    List<IDepartment> getDepartmentList();

    void setDepartmentList(List<IDepartment> departmentList);
}
