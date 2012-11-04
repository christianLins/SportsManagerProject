package sportsclubmanager.dto.classes;

import java.io.Serializable;
import sportsclubmanager.domain.contract.ICountry;

/**

 @author Markus Mohanty <markus.mo at gmx.net>
 */
public class Country
        implements Serializable, ICountry
{
    private String name;
    private String alpha3;
    private String alpha2;
    private String tld;
    private String deutsch;
    private String espanol;
    private String francaise;
    private String italiano;
    private String portugues;

    public Country()
    {
    }

    public Country(ICountry c)
    {
        this.name = c.getName();
        this.alpha3 = c.getAlpha3();
        this.alpha2 = c.getAlpha2();
        this.tld = c.getTld();
        this.deutsch = c.getDeutsch();
        this.espanol = c.getEspanol();
        this.francaise = c.getFrancaise();
        this.italiano = c.getItaliano();
        this.portugues = c.getPortugues();
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
    public String getAlpha3()
    {
        return alpha3;
    }

    @Override
    public void setAlpha3(String alpha3)
    {
        this.alpha3 = alpha3;
    }

    @Override
    public String getAlpha2()
    {
        return alpha2;
    }

    @Override
    public void setAlpha2(String alpha2)
    {
        this.alpha2 = alpha2;
    }

    @Override
    public String getTld()
    {
        return tld;
    }

    @Override
    public void setTld(String tld)
    {
        this.tld = tld;
    }

    @Override
    public String getDeutsch()
    {
        return deutsch;
    }

    @Override
    public void setDeutsch(String deutsch)
    {
        this.deutsch = deutsch;
    }

    @Override
    public String getEspanol()
    {
        return espanol;
    }

    @Override
    public void setEspanol(String espanol)
    {
        this.espanol = espanol;
    }

    @Override
    public String getFrancaise()
    {
        return francaise;
    }

    @Override
    public void setFrancaise(String francaise)
    {
        this.francaise = francaise;
    }

    @Override
    public String getItaliano()
    {
        return italiano;
    }

    @Override
    public void setItaliano(String italiano)
    {
        this.italiano = italiano;
    }

    @Override
    public String getPortugues()
    {
        return portugues;
    }

    @Override
    public void setPortugues(String portugues)
    {
        this.portugues = portugues;
    }
}
