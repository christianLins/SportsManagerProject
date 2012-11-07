/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.Country;
import sportsclubmanager.dto.contract.ICountry;
import sportsclubmanager.dto.controller.contract.*;

/**

 @author Thomas
 */
 class CountryController
        implements IController<ICountry>
{
    private static CountryController controller;

     sportsclubmanager.domain.contract.ICountry getDomainById(int id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ICountry a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICountry.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }

        throw new IdNotFoundException();
    }

    public CountryController()
    {
    }

    public static IController<ICountry> getInstance()
    {
        if (controller == null)
        {
            controller = new CountryController();
        }

        return controller;
    }

    @Override
    public ICountry getById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ICountry a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICountry.class))
        {
            if (a.getId() == id)
            {
                return Country.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ICountry> getAll()
    {
        List<ICountry> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.ICountry a : DomainFacade.getAll(sportsclubmanager.domain.contract.ICountry.class))
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
            sportsclubmanager.domain.classes.Country country = createDomain(value);

            return DomainFacade.set(country);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ICountry value)
    {
        try
        {
            sportsclubmanager.domain.classes.Country country = createDomain(value);

            DomainFacade.delete(country);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(CountryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private sportsclubmanager.domain.classes.Country createDomain(ICountry value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Country country = new sportsclubmanager.domain.classes.Country(value.getId());

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
