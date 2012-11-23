/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.IRoleDto;
import java.util.*;

/**

 @author Thomas
 */
abstract class RoleDto
        implements IRoleDto
{
    private Integer id;
    private String name;
    private String description;
    private List<Integer> permissionList;
    private List<Integer> memberList;

    public RoleDto()
    {
    }

    public static <T extends RoleDto> T copy(contract.domain.IRole domainRole, T role)
    {
        role.setId(domainRole.getId());
        role.setName(domainRole.getName());
        role.setDescription(domainRole.getDesciption());

        List<Integer> perList = new LinkedList<>();
        for (contract.domain.IPermission permission : domainRole.getPermissionList())
        {
            perList.add(permission.getId());
        }
        role.setPermisssionList(perList);

        List<Integer> memList = new LinkedList<>();

        for (contract.domain.IMember mem : domainRole.getMembers())
        {
            memList.add(mem.getId());
        }
        role.setMembers(memList);

        return role;
    }

    @Override
    public List<Integer> getPermisssionList()
    {
        return permissionList;
    }

    @Override
    public List<Integer> getMembers()
    {
        return memberList;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public void setMembers(List<Integer> members)
    {
        memberList = members;
    }

    @Override
    public void setPermisssionList(List<Integer> permisssionList)
    {
        this.permissionList = permisssionList;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
