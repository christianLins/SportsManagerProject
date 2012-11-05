package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.HashMap;
import sportsclubmanager.dto.contract.IPermission;

public class Permission
        implements Serializable, IPermission
{
    private int id;
    private String name;
    private String description;
    private static HashMap<sportsclubmanager.domain.contract.IPermission, Permission> competitions = new HashMap<>();

    public Permission(int id)
    {
        this.id = id;
    }

    public static Permission copy(sportsclubmanager.domain.contract.IPermission permission)
    {
        Permission a;

        if (competitions.containsKey(permission))
        {
            a = competitions.get(permission);
        }
        else
        {
            a = new Permission(permission.getId());

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

    @Override
    public Integer getId()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
