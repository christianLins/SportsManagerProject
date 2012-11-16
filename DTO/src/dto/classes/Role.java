package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.IRole;

public class Role
        implements Serializable, IRole
{
    private int id;
    private String name;
    private List<Integer> permissionList = new LinkedList<>();
    private List<Integer> members = new LinkedList<>();

     Role()
    {
    }

     Role(int id)
    {
        this.id = id;
    }

     Role(domain.contract.IRole c)
    {
        this.id = c.getId();
        this.name = c.getName();
        
        for(domain.contract.IMember m : c.getMembers())
        {
            members.add(m.getId());
        }

        for (domain.contract.IPermission d : c.getPermisssionList())
        {
            permissionList.add(d.getId());
        }
    }

    @Override
    public List<Integer> getPermisssionList()
    {
        return permissionList;
    }

    @Override
    public void setPermisssionList(List<Integer> permissionList)
    {
        this.permissionList = permissionList;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public List<Integer> getMembers()
    {
        return this.members;
    }

    @Override
    public void setMembers(List<Integer> members)
    {
        this.members = members;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }
}
