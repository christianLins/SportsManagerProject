package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.dto.contract.IRole;

public class Role
        implements Serializable, IRole
{
    private int id;
    private List<Integer> permissionList = new LinkedList<>();

     Role()
    {
    }

     Role(int id)
    {
        this.id = id;
    }

     Role(sportsclubmanager.domain.contract.IRole c)
    {
        this.id = c.getId();

        for (sportsclubmanager.domain.contract.IPermission d : c.getPermisssionList())
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
}
