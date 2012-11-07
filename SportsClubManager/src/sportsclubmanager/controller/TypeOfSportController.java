/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sportsclubmanager.controller.contract.*;
import sportsclubmanager.domain.CouldNotDeleteException;
import sportsclubmanager.domain.CouldNotSaveException;
import sportsclubmanager.domain.DomainFacade;
import sportsclubmanager.domain.classes.Player;
import sportsclubmanager.dto.classes.TypeOfSport;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class TypeOfSportController
      implements IController<ITypeOfSport>
{
  private static TypeOfSportController controller;

    private TypeOfSportController()
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
    
    @Override
    public ITypeOfSport getById(Integer id) throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.ITypeOfSport a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITypeOfSport.class))
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

        for (sportsclubmanager.domain.contract.ITypeOfSport a : DomainFacade.getAll(sportsclubmanager.domain.contract.ITypeOfSport.class))
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
            sportsclubmanager.domain.classes.TypeOfSport typeofsport = createDomain(value);

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
            sportsclubmanager.domain.classes.TypeOfSport typeofsport = createDomain(value);

            DomainFacade.delete(typeofsport);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private sportsclubmanager.domain.classes.TypeOfSport createDomain(ITypeOfSport value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.TypeOfSport typeofsport = new sportsclubmanager.domain.classes.TypeOfSport(value.getId());

        typeofsport.setDescription(value.getDescription());
        typeofsport.setId(value.getId());
        typeofsport.setName(value.getName());
        LinkedList<sportsclubmanager.domain.contract.IPlayer> list = new LinkedList<>();
        for(Integer id : value.getPlayerList())
        {
            list.add(new PlayerController.getDomainByID(id));
        }
        typeofsport.setPlayerList(list);

        return typeofsport;
    }
    
}
