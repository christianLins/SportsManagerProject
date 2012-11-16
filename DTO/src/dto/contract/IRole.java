/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.List;

/**
 @author Thomas
 */
public interface IRole
        extends IDto
{
    List<Integer> getPermisssionList();
    
    List<Integer> getMembers();
    
    String getName();
    
    void setName(String name);
    
    void setMembers(List<Integer> members);

    void setPermisssionList(List<Integer> permisssionList);
}
