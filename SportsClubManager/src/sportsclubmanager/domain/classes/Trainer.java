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
@Table(name = "Trainer")
@XmlRootElement
public class Trainer extends Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "trainerList")
    private List<ClubTeam> clubTeamList;

    public Trainer()
    {
    }

    @XmlTransient
    public List<ClubTeam> getClubTeamList()
    {
        return clubTeamList;
    }

    public void setClubTeamList(List<ClubTeam> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }
}
