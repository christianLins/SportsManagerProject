package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Role
        implements Serializable, IRole
{
    private List<Permission> permissionList = new LinkedList<>();

    public Role()
    {
    }

    public Role(IRole c)
    {
        for (IPermission d : c.getPermisssionList())
        {
            permissionList.add(Permission.copy(d));
        }
    }

    @Override
    public List<IPermission> getPermisssionList()
    {
        List<IPermission> result = new LinkedList<>();

        for (Permission c : permissionList)
        {
            result.add(c);
        }

        return result;
    }

    @Override
    public void setPermisssionList(List<IPermission> permissionList)
    {
        List<Permission> result = new LinkedList<>();

        for (IPermission c : permissionList)
        {
            result.add(Permission.copy(c));
        }

        this.permissionList = result;
    }
}
