/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.*;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class PermissionController
        implements IController<IPermission>
{
    private static PermissionController controller;

    private PermissionController()
    {
    }

    public static IController<IPermission> getInstance()
    {
        if (controller == null)
        {
            controller = new PermissionController();
        }

        return controller;
    }

    @Override
    public IPermission getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IPermission a : DomainFacade.getAll(sportsclubmanager.domain.contract.IPermission.class))
        {
            if (a.getId() == id)
            {
                return Permission.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IPermission> getAll()
    {
        List<IPermission> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IPermission a : DomainFacade.getAll(sportsclubmanager.domain.contract.IPermission.class))
        {
            result.add(Permission.copy(a));
        }

        return result;
    }

    @Override
    public void set(IPermission value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
