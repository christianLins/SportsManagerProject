/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.mapper;

import contract.domain.*;
import contract.dto.ICountry;
import contract.dto.mapper.*;
import java.util.*;
import java.util.logging.*;
import server.domain.DomainFacade;
import server.dto.classes.Country;

/**

 @author Thomas
 */
public class CountryMapper
        implements IMapper<ICountry>
{
    private static CountryMapper controller;

    contract.domain.ICountry getDomainById(int id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ICountry a = DomainFacade.getInstance().getByID(contract.domain.ICountry.class, id);
            return a;
        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    public CountryMapper()
    {
    }

    public static IMapper<ICountry> getInstance()
    {
        if (controller == null)
        {
            controller = new CountryMapper();
        }

        return controller;
    }

    @Override
    public ICountry getById(Integer id)
            throws IdNotFoundException
    {
        try
        {
            contract.domain.ICountry a = DomainFacade.getInstance().getByID(contract.domain.ICountry.class, id);
            return Country.copy(a);

        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ICountry> getAll()
            throws NotFoundException
    {
        try
        {
            List<ICountry> result = new LinkedList<>();

            for (contract.domain.ICountry a : DomainFacade.getInstance().getAll(contract.domain.ICountry.class))
            {
                result.add(Country.copy(a));
            }

            return result;
        }
        catch (CouldNotFetchException ex)
        {
            throw new NotFoundException(ex);
        }
    }

    @Override
    public Integer set(ICountry value)
    {
        try
        {
            server.domain.classes.Country country = createDomain(value);

            return DomainFacade.getInstance().set(country);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(CountryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ICountry value)
    {
        try
        {
            server.domain.classes.Country country = createDomain(value);

            DomainFacade.getInstance().delete(country);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CountryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private server.domain.classes.Country createDomain(ICountry value)
            throws IdNotFoundException
    {
        server.domain.classes.Country country = new server.domain.classes.Country(value.getId());

        country.setAlpha2(value.getAlpha2());
        country.setAlpha3(value.getAlpha3());
        country.setDeutsch(value.getDeutsch());
        country.setEspanol(value.getEspanol());
        country.setFrancaise(value.getFrancaise());
        country.setItaliano(value.getItaliano());
        country.setName(value.getName());
        country.setPortugues(value.getPortugues());
        country.setTld(value.getTld());

        return country;
    }

    @Override
    public ICountry getNew()
    {
        return new Country();
    }
}
