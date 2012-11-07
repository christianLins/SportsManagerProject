/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.controller;

import java.util.*;
import java.util.logging.*;
import domain.*;
import dto.classes.TypeOfSport;
import dto.contract.ITypeOfSport;
import dto.controller.contract.*;

/**

 @author Thomas
 */
 public class TypeOfSportController
        implements IController<ITypeOfSport>
{
    private static TypeOfSportController controller;

     TypeOfSportController()
    {
    }

    public static IController<ITypeOfSport> getInstance()
    {
        if (controller == null)
        {
            controller = new TypeOfSportController();
        }

        return controller;
    }

    public domain.contract.ITypeOfSport getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.ITypeOfSport a : DomainFacade.getAll(domain.contract.ITypeOfSport.class))
        {
            if (a.getId() == id)
            {
                return a;
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public ITypeOfSport getById(Integer id)
            throws IdNotFoundException
    {
        for (domain.contract.ITypeOfSport a : DomainFacade.getAll(domain.contract.ITypeOfSport.class))
        {
            if (a.getId() == id)
            {
                return TypeOfSport.copy(a);
            }
        }

        throw new IdNotFoundException();
    }

    @Override
    public List<ITypeOfSport> getAll()
    {
        List<ITypeOfSport> result = new LinkedList<>();

        for (domain.contract.ITypeOfSport a : DomainFacade.getAll(domain.contract.ITypeOfSport.class))
        {
            result.add(TypeOfSport.copy(a));
        }

        return result;
    }

    @Override
    public Integer set(ITypeOfSport value)
    {
        try
        {
            domain.classes.TypeOfSport typeofsport = createDomain(value);

            return DomainFacade.set(typeofsport);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(ITypeOfSport value)
    {
        try
        {
            domain.classes.TypeOfSport typeofsport = createDomain(value);

            DomainFacade.delete(typeofsport);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private domain.classes.TypeOfSport createDomain(ITypeOfSport value)
            throws IdNotFoundException
    {
        domain.classes.TypeOfSport typeofsport = new domain.classes.TypeOfSport(value.getId());

        typeofsport.setDescription(value.getDescription());
        typeofsport.setId(value.getId());
        typeofsport.setName(value.getName());
        LinkedList<domain.contract.IPlayer> list = new LinkedList<>();
        for (Integer id : value.getPlayerList())
        {
            list.add(new PlayerController().getDomainById(id));
        }
        typeofsport.setPlayerList(list);

        return typeofsport;
    }
}
