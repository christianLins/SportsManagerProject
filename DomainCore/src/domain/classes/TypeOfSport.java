package domain.classes;

import domain.contract.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
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
        @JoinColumn(name = "TypeOfSport_idTypeOfSport")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Player_Role_idRole")
    })
    @ManyToMany
    private List<Player> playerList;
    @JoinTable(name = "TypeOfSport_has_Trainer", joinColumns =
    {
        @JoinColumn(name = "TypeOfSport_idTypeOfSport")
    },
    inverseJoinColumns =
    {
        @JoinColumn(name = "Trainer_idTrainer")
    })
    @ManyToMany
    private List<Trainer> trainerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfSports")
    private List<Department> departments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sport")
    private List<Competition> competitions;

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

    @Override
    public List<ICompetition> getCompetitions()
    {
        List<ICompetition> comps = new LinkedList<>();
        for (Competition c : competitions)
        {
            comps.add(c);
        }
        return comps;
    }

    @Override
    public void setCompetitions(List<ICompetition> competitions)
    {
        if (this.competitions == null)
        {
            this.competitions = new LinkedList<>();
        }
        for (ICompetition c : competitions)
        {
            this.competitions.add((Competition) c);
        }
    }

    @Override
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

    @XmlTransient
    @Override
    public List<IPlayer> getPlayerList()
    {
        List<IPlayer> result = new LinkedList<>();

        for (Player d : playerList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
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

    public List<Trainer> getTrainerList()
    {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList)
    {
        this.trainerList = trainerList;
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
