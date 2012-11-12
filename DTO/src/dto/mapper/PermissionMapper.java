/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.Permission;
import dto.contract.IPermission;
import dto.mapper.contract.*;

/**

 @author Thomas
 */
 public class PermissionMapper
        implements IMapper<IPermission>
{
    private static PermissionMapper controller;
    
     PermissionMapper()
    {
    }
    
    public static IMapper<IPermission> getInstance()
    {
        if (controller == null)
        {
            controller = new PermissionMapper();
        }
        
        return controller;
    }
    
    public domain.contract.IPermission getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.IPermission a : DomainFacade.getAll(domain.contract.IPermission.class))
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
        for (domain.contract.IPermission a : DomainFacade.getAll(domain.contract.IPermission.class))
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
        
        for (domain.contract.IPermission a : DomainFacade.getAll(domain.contract.IPermission.class))
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
            domain.classes.Permission permission = createDomain(value);
            
            return DomainFacade.set(permission);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    @Override
    public void delete(IPermission value)
    {
        try
        {
            domain.classes.Permission permission = createDomain(value);
            
            DomainFacade.delete(permission);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private domain.classes.Permission createDomain(IPermission value)
            throws IdNotFoundException
    {
        domain.classes.Permission permission = new domain.classes.Permission(value.getId());
        
        permission.setDescription(value.getDescription());
        permission.setName(value.getName());
        
        return permission;
    }
}