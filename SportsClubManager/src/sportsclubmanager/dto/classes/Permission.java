package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Permission
        implements Serializable, IPermission
{
    private String name;
    private String description;

    public Permission()
    {
    }
    private static HashMap<IPermission, Permission> competitions = new HashMap<>();

    public static Permission copy(IPermission permission)
    {
        Permission a;

        if (competitions.containsKey(permission))
        {
            a = competitions.get(permission);
        }
        else
        {
            a = new Permission();

            a.setName(permission.getName());
            a.setDescription(permission.getDescription());

            competitions.put(permission, a);
        }

        return a;
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
}
