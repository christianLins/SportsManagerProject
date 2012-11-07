/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.contract;

import java.util.List;

/**
 @author Thomas
 */
public interface IRole extends IDomain
{
    List<IPermission> getPermisssionList();

    void setPermisssionList(List<IPermission> permisssionList);
}
