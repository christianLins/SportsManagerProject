/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

/**

 @author Thomas
 */
public interface IPermission
        extends IDomain
{
    String getDescription();

    String getName();

    void setDescription(String description);

    void setName(String name);
}
