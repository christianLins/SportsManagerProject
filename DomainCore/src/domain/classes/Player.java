package domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import domain.contract.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Player")
@XmlRootElement
public class Player
        extends Role
        implements Serializable, IPlayer
{
    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "playerList")
    private List<TypeOfSport> typeOfSportList;
    @ManyToMany(mappedBy = "players")
    private List<ClubTeam> clubTeams;
    
    public Player()
    {
        
    }
    
    public Player(int id)
    {
        super(id);
    }
    
    Player(IPlayer d)
    {
        typeOfSportList = new LinkedList<>();
        
        for (ITypeOfSport t : d.getTypeOfSportList())
        {
            if (t instanceof TypeOfSport)
            {
                typeOfSportList.add((TypeOfSport) t);
            }
            else
            {
                typeOfSportList.add(new TypeOfSport(t));
            }
        }
    }
    
    @XmlTransient
    public List<IClubTeam> getClubTeams()
    {
        List<IClubTeam> result = new LinkedList<>();
        
        for (ClubTeam d : clubTeams)
        {
            result.add(d);
        }
        
        return result;
    }
    
    public void setClubTeams(List<IClubTeam> clubTeams)
    {
        List<ClubTeam> result = new LinkedList<>();
        
        for (IClubTeam d : clubTeams)
        {
            result.add((ClubTeam) d);
        }
        
        this.clubTeams = result;
    }
    
    @XmlTransient
    @Override
    public List<ITypeOfSport> getTypeOfSportList()
    {
        List<ITypeOfSport> result = new LinkedList<>();
        
        for (TypeOfSport d : typeOfSportList)
        {
            result.add((ITypeOfSport)d);
        }
        
        return result;
    }
    
    @Override
    public void setTypeOfSportList(List<ITypeOfSport> typeOfSportList)
    {
        List<TypeOfSport> result = new LinkedList<>();
        
        for (ITypeOfSport d : typeOfSportList)
        {
            result.add((TypeOfSport) d);
        }
        
        this.typeOfSportList = result;
    }
}
