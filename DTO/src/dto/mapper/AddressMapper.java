/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import dto.mapper.contract.NotFoundException;
import domain.*;
import dto.classes.Address;
import dto.contract.IAddress;
import dto.mapper.contract.*;
import java.util.*;
import java.util.logging.*;

/**
 * @author Thomas
 */
public class AddressMapper
        implements IMapper<IAddress>
{
    private static AddressMapper controller;

    AddressMapper()
    {
    }

    public static IMapper<IAddress> getInstance()
    {
        if (controller == null)
        {
            controller = new AddressMapper();
        }

        return controller;
    }

    public domain.contract.IAddress getDomainById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            return DomainFacade.getInstance().getByID(domain.contract.IAddress.class, id);
        }
        catch (Exception ex)
        {
            throw new IdNotFoundException();
        }
    }

    @Override
    public IAddress getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.IAddress a = DomainFacade.getInstance().getByID(domain.contract.IAddress.class, id);
            return Address.copy(a);
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<IAddress> getAll() throws NotFoundException
    {
        try
        {
            List<IAddress> result = new LinkedList<>();

            for (domain.contract.IAddress a : DomainFacade.getInstance().getAll(domain.contract.IAddress.class))
            {
                result.add(Address.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(IAddress value)
    {
        try
        {
            domain.classes.Address address = createDomain(value);

            return DomainFacade.getInstance().set(address);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IAddress value)
    {
        try
        {
            domain.classes.Address address = createDomain(value);

            DomainFacade.getInstance().delete(address);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Address createDomain(IAddress value)
            throws IdNotFoundException
    {
        domain.classes.Address address = new domain.classes.Address(value.getId());

        address.setCountry(new CountryMapper().getDomainById(value.getCountry()));
        address.setPostalCode(value.getPostalCode());
        address.setStreet(value.getStreet());
        address.setStreetNumber(value.getStreetNumber());
        address.setVillage(value.getVillage());

        return address;
    }
}
