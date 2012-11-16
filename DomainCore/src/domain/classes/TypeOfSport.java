package domain.classes;

import domain.contract.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "TypeOfSport")
@XmlRootElement
public class TypeOfSport
        implements Serializable, ITypeOfSport
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTypeOfSport")
    private Integer id;
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

    public TypeOfSport(ITypeOfSport typeOfSport)
    {
        this.name = typeOfSport.getName();
        this.description = typeOfSport.getDescription();
    }

    public TypeOfSport(Integer id)
    {
        this.id = id;
    }

    public TypeOfSport(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @XmlTransient
    public List<IPlayer> getPlayerList()
    {
        List<IPlayer> result = new LinkedList<>();

        for (Player d : playerList)
        {
            result.add(d);
        }

        return result;
    }

    public void setPlayerList(List<IPlayer> playerList)
    {
        List<Player> result = new LinkedList<>();

        for (IPlayer d : playerList)
        {
            result.add((Player) d);
        }

        this.playerList = result;
    }

    @XmlTransient
    public List<IDepartment> getDepartments()
    {
        List<IDepartment> result = new LinkedList<>();

        for (Department d : departments)
        {
            result.add(d);
        }

        return result;
    }

    public void setDepartments(List<IDepartment> departments)
    {
        List<Department> result = new LinkedList<>();

        for (IDepartment d : departments)
        {
            result.add((Department) d);
        }

        this.departments = result;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.TypeOfSport[ id=" + id + " ]";
    }
}
