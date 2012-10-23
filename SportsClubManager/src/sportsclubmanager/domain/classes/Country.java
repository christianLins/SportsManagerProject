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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "Country")
@XmlRootElement
public class Country implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCountry")
    private Integer idCountry;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Lob
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Collection<Address> addressCollection;

    public Country()
    {
    }

    public Country(Integer idCountry)
    {
        this.idCountry = idCountry;
    }

    public Country(Integer idCountry, String name)
    {
        this.idCountry = idCountry;
        this.name = name;
    }

    public Integer getIdCountry()
    {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry)
    {
        this.idCountry = idCountry;
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
    public Collection<Address> getAddressCollection()
    {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection)
    {
        this.addressCollection = addressCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idCountry != null ? idCountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country))
        {
            return false;
        }
        Country other = (Country) object;
        if ((this.idCountry == null && other.idCountry != null) || (this.idCountry != null && !this.idCountry.equals(other.idCountry)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.Country[ idCountry=" + idCountry + " ]";
    }
    
}
