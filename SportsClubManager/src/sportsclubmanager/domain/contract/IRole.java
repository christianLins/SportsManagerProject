/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;
import javax.xml.bind.annotation.*;
import sportsclubmanager.domain.classes.DepartmentHead;
import sportsclubmanager.domain.classes.DepartmentHead;
import sportsclubmanager.domain.classes.Member;
import sportsclubmanager.domain.classes.Member;
import sportsclubmanager.domain.classes.Permission;
import sportsclubmanager.domain.classes.Permission;
import sportsclubmanager.domain.classes.Player;
import sportsclubmanager.domain.classes.Player;
import sportsclubmanager.domain.classes.Trainer;
import sportsclubmanager.domain.classes.Trainer;

/**

 @author Thomas
 */
public interface IRole
{
    List<IPermission> getPermisssionList();

    void setPermisssionList(List<IPermission> permisssionList);
}
