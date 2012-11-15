/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import domain.*;
import dto.classes.DepartmentHead;
import dto.contract.IDepartmentHead;
import dto.mapper.contract.*;
import java.util.*;
import java.util.logging.*;

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

    public domain.contract.IDepartmentHead getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IDepartmentHead a = DomainFacade.getInstance().getByID(domain.contract.IDepartmentHead.class, id);
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
            domain.contract.IDepartmentHead a = DomainFacade.getInstance().getByID(domain.contract.IDepartmentHead.class,id);
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

            for (domain.contract.IDepartmentHead a : DomainFacade.getInstance().getAll(domain.contract.IDepartmentHead.class))
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
            domain.classes.DepartmentHead departmentHead = createDomain(value);

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
            domain.classes.DepartmentHead departmentHead = createDomain(value);

            DomainFacade.getInstance().delete(departmentHead);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentHeadMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.DepartmentHead createDomain(IDepartmentHead value)
            throws IdNotFoundException
    {
        domain.classes.DepartmentHead departmentHead = new domain.classes.DepartmentHead(value.getId());

        List< domain.contract.IDepartment> departmentList = new LinkedList<>();
        List<domain.contract.IPermission> permissionList = new LinkedList<>();

        for (int i : value.getDepartmentList())
        {
            departmentList.add(new DepartmentMapper().getDomainById(i));
        }

        for (int i : value.getPermisssionList())
        {
            permissionList.add(new PermissionMapper().getDomainById(i));
        }

        departmentHead.setDepartmentList(departmentList);
        departmentHead.setPermisssionList(permissionList);

        return departmentHead;
    }
}
