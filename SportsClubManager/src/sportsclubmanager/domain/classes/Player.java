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
public class Player extends Role implements Serializable{
    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "playerList")
    private List<TypeOfSport> typeOfSportList;
//    @JoinColumn(name = "Role_idRole", referencedColumnName = "idRole", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Role role;

    public Player()
    {
    }

//    public Player(Integer roleidRole)
//    {
//        this.roleidRole = roleidRole;
//    }
//
//    public Integer getRoleidRole()
//    {
//        return roleidRole;
//    }
//
//    public void setRoleidRole(Integer roleidRole)
//    {
//        this.roleidRole = roleidRole;
//    }

    @XmlTransient
    public List<TypeOfSport> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    public void setTypeOfSportList(List<TypeOfSport> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
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
//        hash += (roleidRole != null ? roleidRole.hashCode() : 0);
//        return hash;
//    }
}
