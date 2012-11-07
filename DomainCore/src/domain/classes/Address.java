package domain.classes;

import domain.contract.IAddress;
import domain.contract.ICountry;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Address")
@XmlRootElement
public class Address
        implements Serializable, IAddress
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAddress")
    private Integer idAddress;
    @Basic(optional = false)
    @Column(name = "Street")
    private String street;
    @Basic(optional = false)
    @Column(name = "StreetNumber")
    private int streetNumber;
    @Basic(optional = false)
    @Column(name = "Village")
    private String village;
    @Basic(optional = false)
    @Column(name = "PostalCode")
    private int postalCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Member> member1List;
    @JoinColumn(name = "Country", referencedColumnName = "idCountry")
    @ManyToOne(optional = false)
    private Country country;

    public Address()
    {
    }

    public Address(Integer idAddress)
    {
        this.idAddress = idAddress;
    }

    public Address(String street, int streetNumber, String village, int postalCode, Country country)
    {
        this.street = street;
        this.streetNumber = streetNumber;
        this.village = village;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(Integer idAddress, String street, int streetNumber, String village, int postalCode)
    {
        this.idAddress = idAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.village = village;
        this.postalCode = postalCode;
    }

    public Integer getId()
    {
        return idAddress;
    }

    public void setId(Integer idAddress)
    {
        this.idAddress = idAddress;
    }

    @Override
    public String getStreet()
    {
        return street;
    }

    @Override
    public void setStreet(String street)
    {
        this.street = street;
    }

    @Override
    public int getStreetNumber()
    {
        return streetNumber;
    }

    @Override
    public void setStreetNumber(int streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    @Override
    public String getVillage()
    {
        return village;
    }

    @Override
    public void setVillage(String village)
    {
        this.village = village;
    }

    @Override
    public int getPostalCode()
    {
        return postalCode;
    }

    @Override
    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }

    @XmlTransient
    public List<Member> getMember1List()
    {
        return member1List;
    }

    public void setMember1List(List<Member> member1List)
    {
        this.member1List = member1List;
    }

    @Override
    public ICountry getCountry()
    {
        return (ICountry) country;
    }

    @Override
    public void setCountry(ICountry country)
    {
        this.country = (Country) country;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address))
        {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.classes.Address[ idAddress=" + idAddress + " ]";
    }
}
