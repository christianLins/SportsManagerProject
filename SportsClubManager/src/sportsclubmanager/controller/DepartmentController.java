/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.*;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class DepartmentController
        implements IController<IDepartment>
{
    private static DepartmentController controller;

    private DepartmentController()
    {
    }

    public static IController<IDepartment> getInstance()
    {
        if (controller == null)
        {
            controller = new DepartmentController();
        }

        return controller;
    }

    @Override
    public IDepartment getById(Integer id) throws IdNotFoundException
    {
               for (sportsclubmanager.domain.contract.IDepartment a : DomainFacade.getAll(sportsclubmanager.domain.contract.IDepartment.class))
        {
            if (a.getId() == id)
            {
                return Department.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IDepartment> getAll()
    {
          List<IDepartment> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IDepartment a : DomainFacade.getAll(sportsclubmanager.domain.contract.IDepartment.class))
        {
            result.add(Department.copy(a));
        }

        return result;
    }

    @Override
    public void set(IDepartment value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
