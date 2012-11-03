package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class Role
        implements Serializable, IRole
{
    private List<Permission> permisssionList;

    @Override
    public List<IPermission> getPermisssionList()
    {
        return permisssionList;
    }

    @Override
    public void setPermisssionList(List<IPermission> permisssionList)
    {
        this.permisssionList = permisssionList;
    }
}
