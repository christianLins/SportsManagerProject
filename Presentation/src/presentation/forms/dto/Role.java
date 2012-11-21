/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IRole;
import java.util.*;

/**

 @author Thomas
 */
public class Role
        implements IRole
{
    List<Integer> permisssionList;
    List<Integer> members;
    String name;

    @Override
    public List<Integer> getPermisssionList()
    {
        return permisssionList;
    }

    @Override
    public void setPermisssionList(List<Integer> permisssionList)
    {
        this.permisssionList = permisssionList;
    }

    @Override
    public List<Integer> getMembers()
    {
        return members;
    }

    @Override
    public void setMembers(List<Integer> members)
    {
        this.members = members;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }
    String description;

    @Override
    public Integer getId()
    {
        return null;
    }
}
