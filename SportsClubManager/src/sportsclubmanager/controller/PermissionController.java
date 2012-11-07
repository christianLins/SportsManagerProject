/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.controller.contract.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.Permission;
import sportsclubmanager.dto.contract.IPermission;

/**

 @author Thomas
 */
public class PermissionController
        implements IController<IPermission>
{
    private static PermissionController controller;
    
    public PermissionController()
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
    
    public sportsclubmanager.domain.contract.IPermission getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IPermission a : DomainFacade.getAll(sportsclubmanager.domain.contract.IPermission.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }
        
        throw new IdNotFoundException();
    }
    
    @Override
    public IPermission getById(Integer id)
            throws IdNotFoundException
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
    public Integer set(IPermission value)
    {
        try
        {
            sportsclubmanager.domain.classes.Permission permission = createDomain(value);
            
            return DomainFacade.set(permission);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(PermissionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    @Override
    public void delete(IPermission value)
    {
        try
        {
            sportsclubmanager.domain.classes.Permission permission = createDomain(value);
            
            DomainFacade.delete(permission);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PermissionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private sportsclubmanager.domain.classes.Permission createDomain(IPermission value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Permission permission = new sportsclubmanager.domain.classes.Permission(value.getId());
        
        permission.setDescription(value.getDescription());
        permission.setName(value.getName());
        
        return permission;
    }
}
