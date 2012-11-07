/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

/**

 @author Thomas
 */
public interface IAddress
        extends IDto
{
    int getCountry();

    int getPostalCode();

    String getStreet();

    int getStreetNumber();

    String getVillage();

    void setCountry(int country);

    void setPostalCode(int postalCode);

    void setStreet(String street);

    void setStreetNumber(int streetNumber);

    void setVillage(String village);
}
