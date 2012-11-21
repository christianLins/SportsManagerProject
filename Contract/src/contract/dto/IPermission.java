/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

/**

 @author Thomas
 */
public interface IPermission
        extends IDto
{
    String getDescription();

    String getName();

    void setDescription(String description);

    void setName(String name);
}
