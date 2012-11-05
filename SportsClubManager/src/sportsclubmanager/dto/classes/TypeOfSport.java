package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class TypeOfSport
        implements Serializable, ITypeOfSport
{
    private String name;
    private String description;
    private List<Player> playerList = new LinkedList<>();

    public TypeOfSport()
    {
    }
    private static HashMap<ITypeOfSport, TypeOfSport> typeOfSports = new HashMap<>();

    public static TypeOfSport copy(ITypeOfSport typeOfSport)
    {
        TypeOfSport a;

        if (typeOfSports.containsKey(typeOfSport))
        {
            a = typeOfSports.get(typeOfSport);
        }
        else
        {
            a = new TypeOfSport();

            a.setName(typeOfSport.getName());
            a.setDescription(typeOfSport.getDescription());
            a.setPlayerList(typeOfSport.getPlayerList());

            typeOfSports.put(typeOfSport, a);
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
    public List<IPlayer> getPlayerList()
    {
        List<IPlayer> result = new LinkedList<>();

        for (Player d : playerList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setPlayerList(List<IPlayer> playerList)
    {
        List<Player> result = new LinkedList<>();

        for (IPlayer d : playerList)
        {
            result.add(Player.copy(d));
        }

        this.playerList = result;
    }
}
