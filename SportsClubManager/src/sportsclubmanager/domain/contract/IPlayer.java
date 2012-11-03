/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;
import javax.xml.bind.annotation.*;

/**

 @author Thomas
 */
public interface IPlayer
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
    //    }
    @XmlTransient
    List<ITypeOfSport> getTypeOfSportList();

    void setTypeOfSportList(List<ITypeOfSport> typeOfSportList);
}
