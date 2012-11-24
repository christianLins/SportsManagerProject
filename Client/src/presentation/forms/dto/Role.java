/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IRoleDto;
import java.util.*;

/**

 @author Thomas
 */
public class Role
        implements IRoleDto
{
    List<Integer> permisssionList;
    Integer member;
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
    public Integer getMember()
    {
        return member;
    }

    @Override
    public void setMember(Integer member)
    {
        this.member = member;
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
