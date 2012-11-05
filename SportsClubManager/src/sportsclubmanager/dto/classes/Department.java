package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Department
        implements Serializable, IDepartment
{
    private DepartmentHead departmentHead;
    private String name;
    private String description;
    private List<ClubTeam> clubTeamList = new LinkedList<>();
    private List<TypeOfSport> typeOfSportList = new LinkedList<>();

    public Department()
    {
    }
    private static HashMap<IDepartment, Department> departments = new HashMap<>();

    public static Department copy(IDepartment department)
    {
        Department a;

        if (departments.containsKey(department))
        {
            a = departments.get(department);
        }
        else
        {
            a = new Department();

            a.setName(department.getName());
            a.setDescription(department.getDescription());
            a.setClubTeamList(department.getClubTeamList());
            a.setTypeOfSportList(department.getTypeOfSportList());

            departments.put(department, a);
        }

        return a;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public List<IClubTeam> getClubTeamList()
    {
        List<IClubTeam> result = new LinkedList<>();

        for (ClubTeam c : clubTeamList)
        {
            result.add(c);
        }

        return result;
    }

    @Override
    public void setClubTeamList(List<IClubTeam> clubTeamList)
    {
        List<ClubTeam> result = new LinkedList<>();

        for (IClubTeam c : clubTeamList)
        {
            result.add(ClubTeam.copy(c));
        }

        this.clubTeamList = result;
    }

    @Override
    public List<ITypeOfSport> getTypeOfSportList()
    {
        List<ITypeOfSport> result = new LinkedList<>();

        for (TypeOfSport c : typeOfSportList)
        {
            result.add(c);
        }

        return result;
    }

    @Override
    public void setTypeOfSportList(List<ITypeOfSport> typeOfSportList)
    {
        List<TypeOfSport> result = new LinkedList<>();

        for (ITypeOfSport c : typeOfSportList)
        {
            result.add(TypeOfSport.copy(c));
        }

        this.typeOfSportList = result;
    }

    @Override
    public IDepartmentHead getDepartmentHead()
    {
        return departmentHead;
    }

    @Override
    public void setDepartmentHead(IDepartmentHead departmentHead)
    {
        this.departmentHead = DepartmentHead.copy(departmentHead);
    }
}
