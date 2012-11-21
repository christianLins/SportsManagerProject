/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IPermission;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.dto.classes.Permission;

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

    public contract.domain.IPermission getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPermission a = DomainFacade.getInstance().getByID(contract.domain.IPermission.class, id);
            return a;
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public IPermission getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IPermission a = DomainFacade.getInstance().getByID(contract.domain.IPermission.class, id);
            return Permission.copy(a);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IPermission> getAll()
            throws NotFoundException
    {
        try
        {
            List<IPermission> result = new LinkedList<>();

            for (contract.domain.IPermission a : DomainFacade.getInstance().getAll(contract.domain.IPermission.class))
            {
                result.add(Permission.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IPermission value)
    {
        try
        {
            server.domain.classes.Permission permission = createDomain(value);

            return DomainFacade.getInstance().set(permission);
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
            server.domain.classes.Permission permission = createDomain(value);

            DomainFacade.getInstance().delete(permission);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(PermissionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Permission createDomain(IPermission value)
            throws IdNotFoundException
    {
        server.domain.classes.Permission permission = new server.domain.classes.Permission(value.getId());

        permission.setDescription(value.getDescription());
        permission.setName(value.getName());

        return permission;
    }

    @Override
    public IPermission getNew()
    {
        return new Permission();
    }
}
