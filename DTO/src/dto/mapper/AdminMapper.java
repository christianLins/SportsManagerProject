/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import domain.*;
import dto.classes.*;
import dto.contract.*;
import dto.mapper.contract.*;
import java.util.*;
import java.util.logging.*;

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

    public domain.contract.IAdmin getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(domain.contract.IAdmin.class, id);
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
            domain.contract.IAdmin a = DomainFacade.getInstance().getByID(domain.contract.IAdmin.class, id);
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

            for (domain.contract.IAdmin a : DomainFacade.getInstance().getAll(domain.contract.IAdmin.class))
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
            domain.classes.Admin address = createDomain(value);

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
            domain.classes.Admin address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AdminMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Admin createDomain(IAdmin value)
            throws IdNotFoundException
    {
        domain.classes.Admin admin = new domain.classes.Admin(value.getId());

        admin.setName(value.getName());
        admin.setDescription(value.getDescription());

        return admin;
    }
}
