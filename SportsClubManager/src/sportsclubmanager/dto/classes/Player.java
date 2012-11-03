package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class Player
        extends Role
        implements Serializable, IPlayer
{
    private List<TypeOfSport> typeOfSportList;

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
}
