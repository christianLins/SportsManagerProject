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
public class CaretakerMapper
        implements IMapper<ICaretaker>
{
    private static CaretakerMapper controller;

    CaretakerMapper()
    {
    }

    public static IMapper<ICaretaker> getInstance()
    {
        if (controller == null)
        {
            controller = new CaretakerMapper();
        }

        return controller;
    }

    public domain.contract.ICaretaker getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(domain.contract.ICaretaker.class, id);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public ICaretaker getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.ICaretaker a = DomainFacade.getInstance().getByID(domain.contract.ICaretaker.class, id);
            return Caretaker.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ICaretaker> getAll()
            throws NotFoundException
    {
        try
        {
            List<ICaretaker> result = new LinkedList<>();

            for (domain.contract.ICaretaker a : DomainFacade.getInstance().getAll(domain.contract.ICaretaker.class))
            {
                result.add(Caretaker.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ICaretaker value)
    {
        try
        {
            domain.classes.Caretaker address = createDomain(value);

            return DomainFacade.getInstance().set(address);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ICaretaker value)
    {
        try
        {
            domain.classes.Caretaker address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CaretakerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Caretaker createDomain(ICaretaker value)
            throws IdNotFoundException
    {
        domain.classes.Caretaker caretaker = new domain.classes.Caretaker(value.getId());

        LinkedList<domain.contract.IPermission> permissionList = new LinkedList<>();
        for (int id : value.getPermisssionList())
        {
            permissionList.add(new PermissionMapper().getDomainById(id));
        }

        caretaker.setPermisssionList(permissionList);


        LinkedList<domain.contract.IMember> members = new LinkedList<>();
        for (int id : value.getMembers())
        {
            members.add(new MemberMapper().getDomainById(id));
        }

        caretaker.getMembers(members);

        caretaker.setName(value.getName());
        caretaker.setDescription(value.getDescription());

        return caretaker;
    }

    @Override
    public ICaretaker getNew()
    {
        return new Caretaker();
    }
}
