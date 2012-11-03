package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Player
        extends Role
        implements Serializable, IPlayer
{
    private List<TypeOfSport> typeOfSportList;

    Player(IPlayer d)
    {
        for (ITypeOfSport c : d.getTypeOfSportList())
        {
            typeOfSportList.add(new TypeOfSport(c));
        }
    }

    @Override
    public List<ITypeOfSport> getTypeOfSportList()
    {
        List<ITypeOfSport> result = new LinkedList<>();

        for (TypeOfSport d : typeOfSportList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setTypeOfSportList(List<ITypeOfSport> typeOfSportList)
    {
        List<TypeOfSport> result = new LinkedList<>();

        for (ITypeOfSport d : typeOfSportList)
        {
            result.add(new TypeOfSport(d));
        }

        this.typeOfSportList = result;
    }
}
