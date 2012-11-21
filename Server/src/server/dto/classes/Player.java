package server.dto.classes;

import contract.dto.IPlayer;
import java.io.Serializable;
import java.util.*;

public class Player
        extends Role
        implements Serializable, IPlayer
{
    private List<Integer> typeOfSportList;
    private List<Integer> memberList;
    private static HashMap<contract.domain.IPlayer, Player> players = new HashMap<>();

    public static Player copy(contract.domain.IPlayer player)
    {
        Player a;

        if (players.containsKey(player))
        {
            a = players.get(player);
        }
        else
        {
            a = copy(player, new Player());

            List<Integer> l = new LinkedList<>();

            for (contract.domain.ITypeOfSport t : player.getTypeOfSportList())
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

    @Override
    public List<Integer> getMembers()
    {
        return this.memberList;
    }

    @Override
    public void setMembers(List<Integer> members)
    {
        this.memberList = members;
    }
}
