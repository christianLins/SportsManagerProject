/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.IAdmin;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.dto.classes.Admin;

/**
 @author Thomas
 */
public class AdminMapper
        implements IMapper<IAdmin>
{
    private static AdminMapper controller;

    AdminMapper()
    {
    }

    public static IMapper<IAdmin> getInstance()
    {
        if (controller == null)
        {
            controller = new AdminMapper();
        }

        return controller;
    }

    public contract.domain.IAdmin getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(contract.domain.IAdmin.class, id);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public IAdmin getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.IAdmin a = DomainFacade.getInstance().getByID(contract.domain.IAdmin.class, id);
            return Admin.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IAdmin> getAll()
            throws NotFoundException
    {
        try
        {
            List<IAdmin> result = new LinkedList<>();

            for (contract.domain.IAdmin a : DomainFacade.getInstance().getAll(contract.domain.IAdmin.class))
            {
                result.add(Admin.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IAdmin value)
    {
        try
        {
            server.domain.classes.Admin address = createDomain(value);

            return DomainFacade.getInstance().set(address);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IAdmin value)
    {
        try
        {
            server.domain.classes.Admin address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Admin createDomain(IAdmin value)
            throws IdNotFoundException
    {
        server.domain.classes.Admin admin = new server.domain.classes.Admin(value.getId());

        admin.setName(value.getName());
        admin.setDescription(value.getDescription());

        return admin;
    }

    @Override
    public IAdmin getNew()
    {
        return new Admin();
    }
}
