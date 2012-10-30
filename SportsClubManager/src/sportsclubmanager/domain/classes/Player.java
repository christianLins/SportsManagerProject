package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Player")
@XmlRootElement
public class Player extends Role implements Serializable
{

    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "playerList")
    private List<TypeOfSport> typeOfSportList;
    @ManyToMany(mappedBy = "players")
    private List<ClubTeam> clubTeams;

    public Player()
    {
    }
    
    @XmlTransient
    public List<ClubTeam> getClubTeams()
    {
        return clubTeams;
    }

    public void setClubTeams(List<ClubTeam> clubTeams)
    {
        this.clubTeams = clubTeams;
    }

    @XmlTransient
    public List<TypeOfSport> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    public void setTypeOfSportList(List<TypeOfSport> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }
}
