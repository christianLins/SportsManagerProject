package sportsclubmanager.dto.classes;

import java.io.Serializable;
import sportsclubmanager.domain.classes.Country;
import sportsclubmanager.domain.contract.*;

public class Address
        implements Serializable, IAddress
{
    private String street;
    private int streetNumber;
    private String village;
    private int postalCode;
    private Country country;

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

    @Override
    public ICountry getCountry()
    {
        return country;
    }

    @Override
    public void setCountry(ICountry country)
    {
        this.country = (Country) country;
    }
}
