package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class TypeOfSport
        implements Serializable, ITypeOfSport
{
    private String name;
    private String description;
    private List<Player> playerList;

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
        return playerList;
    }

    @Override
    public void setPlayerList(List<IPlayer> playerList)
    {
        this.playerList = playerList;
    }
}
