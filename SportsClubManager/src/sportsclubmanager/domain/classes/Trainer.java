package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import sportsclubmanager.domain.contract.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Trainer")
@XmlRootElement
public class Trainer
        extends Role
        implements Serializable, ITrainer
{
    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "trainerList")
    private List<ClubTeam> clubTeamList;

    public Trainer()
    {
    }

    @XmlTransient
    @Override
    public List<IClubTeam> getClubTeamList()
    {
        List<IClubTeam> result = new LinkedList<>();

        for (ClubTeam d : clubTeamList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setClubTeamList(List<IClubTeam> clubTeamList)
    {
        List<ClubTeam> result = new LinkedList<>();

        for (IClubTeam d : clubTeamList)
        {
            result.add((ClubTeam) d);
        }

        this.clubTeamList = result;
    }
}
