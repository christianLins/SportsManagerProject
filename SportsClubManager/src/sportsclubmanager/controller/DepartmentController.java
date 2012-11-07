/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import java.util.logging.*;
import sportsclubmanager.controller.contract.IController;
import sportsclubmanager.domain.*;
import sportsclubmanager.dto.classes.Department;
import sportsclubmanager.dto.contract.*;

/**

 @author Thomas
 */
public class DepartmentController
        implements IController<IDepartment>
{
    private static DepartmentController controller;

    public DepartmentController()
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

    public sportsclubmanager.domain.contract.IDepartment getDomainById(Integer id)
            throws IdNotFoundException
    {
        for (sportsclubmanager.domain.contract.IDepartment a : DomainFacade.getAll(sportsclubmanager.domain.contract.IDepartment.class))
        {
            return a;
        }

        throw new IdNotFoundException();
    }

    @Override
    public IDepartment getById(Integer id)
            throws IdNotFoundException
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
    public Integer set(IDepartment value)
    {
        try
        {
            sportsclubmanager.domain.classes.Department department = createDomain(value);

            return DomainFacade.set(department);
        }
        catch (IdNotFoundException | CouldNotSaveException ex)
        {
            Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    @Override
    public void delete(IDepartment value)
    {
        try
        {
            sportsclubmanager.domain.classes.Department department = createDomain(value);

            DomainFacade.delete(department);
        }
        catch (IdNotFoundException | CouldNotDeleteException ex)
        {
            Logger.getLogger(DepartmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private sportsclubmanager.domain.classes.Department createDomain(IDepartment value)
            throws IdNotFoundException
    {
        sportsclubmanager.domain.classes.Department department = new sportsclubmanager.domain.classes.Department(value.getId());

        department.setDepartmentHead(new DepartmentHeadController().getDomainById(value.getDepartmentHead()));
        department.setDescription(value.getDescription());
        department.setName(value.getName());

        List< sportsclubmanager.domain.contract.IClubTeam> clubTeamList = new LinkedList<>();
        List< sportsclubmanager.domain.contract.ITypeOfSport> departmenthasTypeOfSportList = new LinkedList<>();

        for (int i : value.getClubTeamList())
        {
            clubTeamList.add(new ClubTeamController().getDomainById(i));
        }

        for (int i : value.getTypeOfSportList())
        {
            departmenthasTypeOfSportList.add(new TypeOfSportController().getDomainById(i));
        }

        department.setClubTeamList(clubTeamList);
        department.setTypeOfSportList(departmenthasTypeOfSportList);


        return department;
    }
}
