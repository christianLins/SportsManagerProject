/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.dto;

import java.util.List;

/**
 @author Thomas
 */
public interface IRoleDto
        extends IDto
{
    List<Integer> getPermisssionList();

    Integer getMember();

    String getName();

    String getDescription();

    void setName(String name);

    void setDescription(String description);

    void setMember(Integer member);

    void setPermisssionList(List<Integer> permisssionList);
}
