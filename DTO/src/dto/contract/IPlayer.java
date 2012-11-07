/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface IPlayer
        extends IRole
{
    //    public Player(Integer roleidRole)
    //    {
    //        this.roleidRole = roleidRole;
    //    }
    //
    //    public Integer getRoleidRole()
    //    {
    //        return roleidRole;
    //    }
    //
    //    public void setRoleidRole(Integer roleidRole)
    //    {
    //        this.roleidRole = roleidRole;
    //    
    List<Integer> getTypeOfSportList();

    void setTypeOfSportList(List<Integer> typeOfSportList);
}
