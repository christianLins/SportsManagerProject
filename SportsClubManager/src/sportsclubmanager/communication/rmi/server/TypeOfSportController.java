/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server;

import java.util.*;
import sportsclubmanager.controller.*;
import sportsclubmanager.controller.contract.*;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
class TypeOfSportController
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
    public ITypeOfSport getById(Integer id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ITypeOfSport> getAll()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void set(ITypeOfSport value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
