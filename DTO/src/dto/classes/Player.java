package dto.classes;

import dto.contract.IPlayer;
import java.io.Serializable;
import java.util.*;

public class Player
        extends Role
        implements Serializable, IPlayer
{
    private List<Integer> typeOfSportList;
    private List<Integer> members;

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
            List<Integer> m = new LinkedList<>();
            
            for(domain.contract.IMember mem : player.getMembers())
            {
                m.add(mem.getId());
            }
            a.setMembers(m);

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

    @Override
    public List<Integer> getMembers()
    {
        return this.members;
    }

    @Override
    public void setMembers(List<Integer> members)
    {
        this.members = members;
    }
}
