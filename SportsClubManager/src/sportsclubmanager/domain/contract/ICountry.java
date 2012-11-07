/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

/**

 @author Thomas
 */
public interface ICountry
{
        Integer getId();

        String getAlpha2();

    String getAlpha3();

    String getDeutsch();

    String getEspanol();

    String getFrancaise();

    String getItaliano();

    String getName();

    String getPortugues();

    String getTld();

    void setAlpha2(String alpha2);

    void setAlpha3(String alpha3);

    void setDeutsch(String deutsch);

    void setEspanol(String espanol);

    void setFrancaise(String francaise);

    void setItaliano(String italiano);

    void setName(String name);

    void setPortugues(String portugues);

    void setTld(String tld);
    
}
