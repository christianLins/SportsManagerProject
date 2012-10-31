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
@Table(name = "Country")
@XmlRootElement
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCountry")
    private Integer idCountry;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Alpha3")
    private String alpha3;
    @Column(name = "Alpha2")
    private String alpha2;
    @Column(name = "TLD")
    private String tld;
    @Column(name = "Deutsch")
    private String deutsch;
    @Column(name = "Espanol")
    private String espanol;
    @Column(name = "Francaise")
    private String francaise;
    @Column(name = "Italiano")
    private String italiano;
    @Column(name = "Portugues")
    private String portugues;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationality")
    private List<Member> member1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<Address> addressList;

    public Country()
    {
    }

    public Country(String name, String alpha3, String alpha2, String tld, String deutsch, String espanol, String francaise, String italiano, String portugues)
    {
        this.name = name;
        this.alpha3 = alpha3;
        this.alpha2 = alpha2;
        this.tld = tld;
        this.deutsch = deutsch;
        this.espanol = espanol;
        this.francaise = francaise;
        this.italiano = italiano;
        this.portugues = portugues;
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

    public String getAlpha3()
    {
        return alpha3;
    }

    public void setAlpha3(String alpha3)
    {
        this.alpha3 = alpha3;
    }

    public String getAlpha2()
    {
        return alpha2;
    }

    public void setAlpha2(String alpha2)
    {
        this.alpha2 = alpha2;
    }

    public String getTld()
    {
        return tld;
    }

    public void setTld(String tld)
    {
        this.tld = tld;
    }

    public String getDeutsch()
    {
        return deutsch;
    }

    public void setDeutsch(String deutsch)
    {
        this.deutsch = deutsch;
    }

    public String getEspanol()
    {
        return espanol;
    }

    public void setEspanol(String espanol)
    {
        this.espanol = espanol;
    }

    public String getFrancaise()
    {
        return francaise;
    }

    public void setFrancaise(String francaise)
    {
        this.francaise = francaise;
    }

    public String getItaliano()
    {
        return italiano;
    }

    public void setItaliano(String italiano)
    {
        this.italiano = italiano;
    }

    public String getPortugues()
    {
        return portugues;
    }

    public void setPortugues(String portugues)
    {
        this.portugues = portugues;
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

    @XmlTransient
    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<Address> addressList)
    {
        this.addressList = addressList;
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
        return "sportsclubmanager.domain.classes.Country[ idCountry=" + idCountry + " ]";
    }

}
