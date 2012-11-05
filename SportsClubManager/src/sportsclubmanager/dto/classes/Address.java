package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.HashMap;
import sportsclubmanager.dto.contract.IAddress;

public class Address
        implements Serializable, IAddress
{
    private int id;
    private String street;
    private int streetNumber;
    private String village;
    private int postalCode;
    private int country;
    private static HashMap<sportsclubmanager.domain.contract.IAddress, Address> addresses = new HashMap<>();

    public Address(int id)
    {
        this.id = id;
    }

    public static Address copy(sportsclubmanager.domain.contract.IAddress address)
    {
        Address a;

        if (addresses.containsKey(address))
        {
            a = addresses.get(address);
        }
        else
        {
            a = new Address(address.getId());

            a.setStreet(address.getStreet());
            a.setPostalCode(address.getPostalCode());
            a.setStreetNumber(address.getStreetNumber());
            a.setVillage(address.getVillage());
            a.setCountry(address.getCountry().getId());

            addresses.put(address, a);
        }

        return a;
    }

    Address()
    {
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

    @Override
    public int getCountry()
    {
        return country;
    }

    @Override
    public void setCountry(int country)
    {
        this.country = country;
    }

    @Override
    public Integer getId()
    {
        return id;
    }
}