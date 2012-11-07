/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

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
    List<ITypeOfSport> getTypeOfSportList();

    void setTypeOfSportList(List<ITypeOfSport> typeOfSportList);
}
