/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Address")
@XmlRootElement
public class Address implements Serializable
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
    @Column(name = "Addresscol")
    private String addresscol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private Collection<Member1> member1Collection;
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

    public Address(Integer idAddress, String street, int streetNumber, String village, int postalCode)
    {
        this.idAddress = idAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.village = village;
        this.postalCode = postalCode;
    }
    
      public Address(String street, int streetNumber, String village, int postalCode, Country country)
    {
        this.idAddress = idAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.village = village;
        this.postalCode = postalCode;
    }

    public Integer getIdAddress()
    {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress)
    {
        this.idAddress = idAddress;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getStreetNumber()
    {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    public String getVillage()
    {
        return village;
    }

    public void setVillage(String village)
    {
        this.village = village;
    }

    public int getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(int postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getAddresscol()
    {
        return addresscol;
    }

    public void setAddresscol(String addresscol)
    {
        this.addresscol = addresscol;
    }

    @XmlTransient
    public Collection<Member1> getMember1Collection()
    {
        return member1Collection;
    }

    public void setMember1Collection(Collection<Member1> member1Collection)
    {
        this.member1Collection = member1Collection;
    }

    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
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
        return "sportsclubmanager.domain.Address[ idAddress=" + idAddress + " ]";
    }
    
}
