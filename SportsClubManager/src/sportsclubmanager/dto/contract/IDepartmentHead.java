/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface IDepartmentHead
{
    Integer getId();
    
    List<Integer> getDepartmentList();

    void setDepartmentList(List<Integer> departmentList);
}
