package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class Department
        implements Serializable, IDepartment
{
    private DepartmentHead departmentHead;
    private String name;
    private String description;
    private List<ClubTeam> clubTeamList;
    private List<ITypeOfSport> typeOfSportList;

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
        return clubTeamList;
    }

    @Override
    public void setClubTeamList(List<IClubTeam> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }

    @Override
    public List<ITypeOfSport> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    @Override
    public void setTypeOfSportList(List<ITypeOfSport> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }

    @Override
    public IDepartmentHead getDepartmentHead()
    {
        return departmentHead;
    }

    @Override
    public void setDepartmentHead(IDepartmentHead departmentHead)
    {
        this.departmentHead = departmentHead;
    }
}
