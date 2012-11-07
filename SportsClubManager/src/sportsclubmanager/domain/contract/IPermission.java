/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

/**

 @author Thomas
 */
public interface IPermission
{
  Integer getId();
  
  String getDescription();

    String getName();

    void setDescription(String description);

    void setName(String name);
    
}
