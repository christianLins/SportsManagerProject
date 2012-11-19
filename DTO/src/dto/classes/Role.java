/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.classes;

import dto.contract.IRole;
import java.util.*;

/**

 @author Thomas
 */
abstract class Role
        implements IRole
{
    private Integer id;
    private String name;
    private String description;
    private List<Integer> permissionList;
    private List<Integer> memberList;

    public static <T extends Role> T copy(domain.contract.IRole domainRole, T role)
    {
        role.setId(domainRole.getId());
        role.setName(domainRole.getName());
        role.setDescription(domainRole.getDesciption());

        List<Integer> perList = new LinkedList<>();
        for (domain.contract.IPermission permission : domainRole.getPermisssionList())
        {
            perList.add(permission.getId());
        }
        role.setPermisssionList(perList);

        List<Integer> memList = new LinkedList<>();

        for (domain.contract.IMember mem : domainRole.getMembers())
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
}
