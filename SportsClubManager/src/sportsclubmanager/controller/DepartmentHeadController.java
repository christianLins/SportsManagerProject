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
public class DepartmentHeadController
        implements IController<IDepartmentHead>
{
    private static DepartmentHeadController controller;

    private DepartmentHeadController()
    {
    }

    public static IController<IDepartmentHead> getInstance()
    {
        if (controller == null)
        {
            controller = new DepartmentHeadController();
        }

        return controller;
    }

    @Override
    public IDepartmentHead getById(Integer id)throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IDepartmentHead a : DomainFacade.getAll(sportsclubmanager.domain.contract.IDepartmentHead.class))
        {
            if (a.getId() == id)
            {
                return DepartmentHead.copy(a);
            }
        }
        
        throw new IdNotFoundException();
    }

    @Override
    public List<IDepartmentHead> getAll()
    {
        List<IDepartmentHead> result = new LinkedList<>();

        for (sportsclubmanager.domain.contract.IDepartmentHead a : DomainFacade.getAll(sportsclubmanager.domain.contract.IDepartmentHead.class))
        {
            result.add(DepartmentHead.copy(a));
        }

        return result;
    }

    @Override
    public void set(IDepartmentHead value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
