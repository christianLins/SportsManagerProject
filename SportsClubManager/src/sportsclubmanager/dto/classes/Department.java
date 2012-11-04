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

    Department(IDepartment d)
    {
        departmentHead = new DepartmentHead(d.getDepartmentHead());
        name = d.getName();
        description = d.getDescription();

        for (IClubTeam c : d.getClubTeamList())
        {
            clubTeamList.add(new ClubTeam(c));
        }

        for (ITypeOfSport c : d.getTypeOfSportList())
        {
            typeOfSportList.add(new TypeOfSport(c));
        }
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
            result.add(new ClubTeam(c));
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
            result.add(new TypeOfSport(c));
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
        this.departmentHead = new DepartmentHead(departmentHead);
    }
}
