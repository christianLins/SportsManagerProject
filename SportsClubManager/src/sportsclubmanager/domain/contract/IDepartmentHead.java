/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;

/**

 @author Thomas
 */
public interface IDepartmentHead
{
    List<IDepartment> getDepartmentList();

    void setDepartmentList(List<IDepartment> departmentList);
}
