package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
//    @JoinColumn(name = "idTrainer", referencedColumnName = "idRole", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Role role;

    public Trainer()
    {
    }

//    public Trainer(Integer idTrainer)
//    {
//        this.idTrainer = idTrainer;
//    }
//
//    public Integer getIdTrainer()
//    {
//        return idTrainer;
//    }
//
//    public void setIdTrainer(Integer idTrainer)
//    {
//        this.idTrainer = idTrainer;
//    }

    @XmlTransient
    public List<ClubTeam> getClubTeamList()
    {
        return clubTeamList;
    }

    public void setClubTeamList(List<ClubTeam> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }

//    public Role getRole()
//    {
//        return role;
//    }
//
//    public void setRole(Role role)
//    {
//        this.role = role;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int hash = 0;
//        hash += (idTrainer != null ? idTrainer.hashCode() : 0);
//        return hash;
//    }
}
