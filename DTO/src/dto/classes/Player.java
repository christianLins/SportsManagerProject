package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.IPlayer;

public class Player
        extends Role
        implements Serializable, IPlayer
{
    private List<Integer> typeOfSportList;

     Player()
    {
    }
    
     Player(int id)
    {
        super(id);
    }

    private Player(domain.contract.IRole role)
    {
        super(role);
    }
    private static HashMap<domain.contract.IPlayer, Player> players = new HashMap<>();

    public static Player copy(domain.contract.IPlayer player)
    {
        Player a;

        if (players.containsKey(player))
        {
            a = players.get(player);
        }
        else
        {
            a = new Player(player);

            List<Integer> l = new LinkedList<>();

            for (domain.contract.ITypeOfSport t : player.getTypeOfSportList())
            {
                l.add(t.getId());
            }
            a.setTypeOfSportList(l);

            players.put(player, a);
        }

        return a;
    }

    @Override
    public List<Integer> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    @Override
    public void setTypeOfSportList(List<Integer> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }
}
