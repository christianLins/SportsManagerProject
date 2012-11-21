/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.*;

/**

 @author Thomas
 */
public class Country
        implements ICountry
{
    String alpha2;
    String alpha3;
    String deutsch;
    String espanol;
    String francaise;
    String italiano;
    String name;
    String portugues;
    String tld;

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
    public String getAlpha3()
    {
        return alpha3;
    }

    @Override
    public void setAlpha3(String alpha3)
    {
        this.alpha3 = alpha3;
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
    public String getPortugues()
    {
        return portugues;
    }

    @Override
    public void setPortugues(String portugues)
    {
        this.portugues = portugues;
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
    public Integer getId()
    {
        return null;
    }
}
