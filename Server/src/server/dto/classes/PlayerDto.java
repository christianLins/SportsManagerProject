package server.dto.classes;

import contract.dto.IPlayerDto;
import java.io.Serializable;
import java.util.*;

public class PlayerDto
        extends RoleDto
        implements Serializable, IPlayerDto
{
    private List<Integer> typeOfSportList;
    private List<Integer> memberList;
    private static HashMap<contract.domain.IPlayer, PlayerDto> players = new HashMap<>();

    public static PlayerDto copy(contract.domain.IPlayer player)
    {
        PlayerDto a;

        if (players.containsKey(player))
        {
            a = players.get(player);
        }
        else
        {
            a = copy(player, new PlayerDto());

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
