/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IAddressDto;

/**

 @author Thomas
 */
public class Address
        implements IAddressDto
{
    int country;
    int postalCode;
    String street;
    int streetNumber;
    String village;

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
    public Integer getId()
    {
       return null;
    }
}
