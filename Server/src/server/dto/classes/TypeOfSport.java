package dto.classes;

import dto.contract.ITypeOfSport;
import java.io.Serializable;
import java.util.*;

public class TypeOfSport
        implements Serializable, ITypeOfSport
{
    private int id;
    private String name;
    private String description;
    private List<Integer> playerList = new LinkedList<>();

    public TypeOfSport()
    {
    }

    TypeOfSport(int id)
    {
        this.id = id;
    }
    private static HashMap<domain.contract.ITypeOfSport, TypeOfSport> typeOfSports = new HashMap<>();

    public static TypeOfSport copy(domain.contract.ITypeOfSport typeOfSport)
    {
        TypeOfSport a;

        if (typeOfSports.containsKey(typeOfSport))
        {
            a = typeOfSports.get(typeOfSport);
        }
        else
        {
            a = new TypeOfSport(typeOfSport.getId());
            a.setName(typeOfSport.getName());
            a.setDescription(typeOfSport.getDescription());

            List<Integer> pls = new LinkedList<>();
            for (domain.contract.IPlayer p : typeOfSport.getPlayerList())
            {
                pls.add(p.getId());
            }
            a.setPlayerList(pls);

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
    public List<Integer> getPlayerList()
    {
        return playerList;
    }

    @Override
    public void setPlayerList(List<Integer> playerList)
    {
        this.playerList = playerList;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
