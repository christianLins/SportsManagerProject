package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Player
        extends Role
        implements Serializable, IPlayer
{
    private List<TypeOfSport> typeOfSportList;

    public Player()
    {
    }

    private Player(IRole role)
    {
        super(role);
    }
    
    private static HashMap<IPlayer, Player> players = new HashMap<>();

    public static Player copy(IPlayer player)
    {
        Player a;

        if (players.containsKey(player))
        {
            a = players.get(player);
        }
        else
        {
            a = new Player(player);

            a.setTypeOfSportList(player.getTypeOfSportList());

            players.put(player, a);
        }

        return a;
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
            result.add(TypeOfSport.copy(d));
        }

        this.typeOfSportList = result;
    }
}
