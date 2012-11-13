/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mapper;

import domain.*;
import dto.classes.Country;
import dto.contract.ICountry;
import dto.mapper.contract.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Thomas
 */
public class CountryMapper
        implements IMapper<ICountry>
{
    private static CountryMapper controller;

    domain.contract.ICountry getDomainById(int id)
            throws IdNotFoundException
    {
        try
        {
            domain.contract.ICountry a = DomainFacade.getInstance().getByID(domain.contract.ICountry.class, id);
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
            domain.contract.ICountry a = DomainFacade.getInstance().getByID(domain.contract.ICountry.class, id);
            return Country.copy(a);

        }
        catch (Exception ex)
        {

            throw new IdNotFoundException();
        }
    }

    @Override
    public List<ICountry> getAll()
    {
        List<ICountry> result = new LinkedList<>();

        for (domain.contract.ICountry a : DomainFacade.getInstance().getAll(domain.contract.ICountry.class))
        {
            result.add(Country.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(ICountry value)
    {
        try
        {
            domain.classes.Country country = createDomain(value);

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
            domain.classes.Country country = createDomain(value);

            DomainFacade.getInstance().delete(country);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CountryMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.Country createDomain(ICountry value)
            throws IdNotFoundException
    {
        domain.classes.Country country = new domain.classes.Country(value.getId());

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
}
