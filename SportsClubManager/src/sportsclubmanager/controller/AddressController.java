/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.*;
import sportsclubmanager.dto.contract.IAddress;

/**

 @author Thomas
 */
public class AddressController
        implements IController<IAddress>
{
    private static AddressController controller;

    private AddressController()
    {
    }

    public static IController<IAddress> getInstance()
    {
        if (controller == null)
        {
            controller = new AddressController();
        }

        return controller;
    }

    @Override
    public IAddress getById(Integer id) throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IAddress a : DomainFacade.getAll(sportsclubmanager.domain.contract.IAddress.class))
        {
            if (a.getId() == id)
            {
                return Address.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IAddress> getAll()
    {
        List<IAddress> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IAddress a : DomainFacade.getAll(sportsclubmanager.domain.contract.IAddress.class))
        {
            result.add(Address.copy(a));
        }

        return result;
    }

    @Override
    public void set(IAddress value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
