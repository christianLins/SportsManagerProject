/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.*;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class CountryController
        implements IController<ICountry>
{
    private static CountryController controller;

    static sportsclubmanager.domain.contract.ICountry getDomainById(int id)
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

    private CountryController()
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
    public void set(ICountry value)
    {
    }
}
