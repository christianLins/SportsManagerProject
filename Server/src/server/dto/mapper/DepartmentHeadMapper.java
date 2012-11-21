/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IDepartmentHead;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.dto.classes.DepartmentHead;

/**
 *
 * @author Thomas
 */
public class DepartmentHeadMapper
        implements IMapper<IDepartmentHead>
{
    private static DepartmentHeadMapper controller;

    DepartmentHeadMapper()
    {
    }

    public static IMapper<IDepartmentHead> getInstance()
    {
        if (controller == null)
        {
            controller = new DepartmentHeadMapper();
        }

        return controller;
    }

    public contract.domain.IDepartmentHead getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IDepartmentHead a = DomainFacade.getInstance().getByID(contract.domain.IDepartmentHead.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public IDepartmentHead getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IDepartmentHead a = DomainFacade.getInstance().getByID(contract.domain.IDepartmentHead.class,id);
            return DepartmentHead.copy(a);
        }
        catch (CouldNotFetchException ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IDepartmentHead> getAll() throws NotFoundException
    {
        try
        {
            List<IDepartmentHead> result = new LinkedList<>();

            for (contract.domain.IDepartmentHead a : DomainFacade.getInstance().getAll(contract.domain.IDepartmentHead.class))
            {
                result.add(DepartmentHead.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IDepartmentHead value)
    {
        try
        {
            server.domain.classes.DepartmentHead departmentHead = createDomain(value);

            return DomainFacade.getInstance().set(departmentHead);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IDepartmentHead value)
    {
        try
        {
            server.domain.classes.DepartmentHead departmentHead = createDomain(value);

            DomainFacade.getInstance().delete(departmentHead);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.DepartmentHead createDomain(IDepartmentHead value)
            throws IdNotFoundException
    {
        server.domain.classes.DepartmentHead departmentHead = new server.domain.classes.DepartmentHead(value.getId());

        List< contract.domain.IDepartment> departmentList = new LinkedList<>();
        List<contract.domain.IPermission> permissionList = new LinkedList<>();

        for (int i : value.getDepartmentList())
        {
            departmentList.add(new DepartmentMapper().getDomainById(i));
        }

        for (int i : value.getPermisssionList())
        {
            permissionList.add(new PermissionMapper().getDomainById(i));
        }

        departmentHead.setDepartmentList(departmentList);
        departmentHead.setPermissionList(permissionList);

        return departmentHead;
    }

    @Override
    public IDepartmentHead getNew()
    {
        return new DepartmentHead();
    }
}
