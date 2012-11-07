/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

import java.util.*;

/**

 @author Thomas
 */
public interface IMember extends IDomain
{
    Integer getIdMember();

    void setIdMember(Integer idMember);

    IAddress getAddress();

    Date getDateOfBirth();

    String getEmailAddress();

    Boolean getGender();

    String getLastname();

    Date getMemberFrom();

    Date getMemberTo();

    ICountry getNationality();

    String getPrename();

    List<IRole> getRoleList();

    String getTelephonenumber();

    void setAddress(IAddress address);

    void setDateOfBirth(Date dateOfBirth);

    void setEmailAddress(String emailAddress);

    void setGender(Boolean gender);

    void setLastname(String lastname);

    void setMemberFrom(Date memberFrom);

    void setMemberTo(Date memberTo);

    void setNationality(ICountry nationality);

    void setPrename(String prename);

    void setRoleList(List<IRole> roleList);

    void setTelephonenumber(String telephonenumber);
}
