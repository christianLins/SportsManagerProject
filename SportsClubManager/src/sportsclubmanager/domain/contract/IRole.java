/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.List;

/**
 @author Thomas
 */
public interface IRole
{
      Integer getId();

    List<IPermission> getPermisssionList();

    void setPermisssionList(List<IPermission> permisssionList);
}
