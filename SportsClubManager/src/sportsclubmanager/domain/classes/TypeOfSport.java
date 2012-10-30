package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "TypeOfSport")
@XmlRootElement
public class TypeOfSport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTypeOfSport")
    private Integer idTypeOfSport;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @JoinTable(name = "Player_has_TypeOfSport", joinColumns =
    {
        @JoinColumn(name = "TypeOfSport_idTypeOfSport", referencedColumnName = "idTypeOfSport")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Player_Role_idRole", referencedColumnName = "idRole")
    })
    @ManyToMany
    private List<Player> playerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfSports")
    private List<Department> departments;

    public TypeOfSport()
    {
    }

    public TypeOfSport(Integer idTypeOfSport)
    {
        this.idTypeOfSport = idTypeOfSport;
    }

    public TypeOfSport(Integer idTypeOfSport, String name)
    {
        this.idTypeOfSport = idTypeOfSport;
        this.name = name;
    }

    public Integer getIdTypeOfSport()
    {
        return idTypeOfSport;
    }

    public void setIdTypeOfSport(Integer idTypeOfSport)
    {
        this.idTypeOfSport = idTypeOfSport;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @XmlTransient
    public List<Player> getPlayerList()
    {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList)
    {
        this.playerList = playerList;
    }

    @XmlTransient
    public List<Department> getDepartments()
    {
        return departments;
    }

    public void setDepartments(List<Department> departments)
    {
        this.departments = departments;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idTypeOfSport != null ? idTypeOfSport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeOfSport))
        {
            return false;
        }
        TypeOfSport other = (TypeOfSport) object;
        if ((this.idTypeOfSport == null && other.idTypeOfSport != null) || (this.idTypeOfSport != null && !this.idTypeOfSport.equals(other.idTypeOfSport)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.TypeOfSport[ idTypeOfSport=" + idTypeOfSport + " ]";
    }

}
