/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.domain;

import java.util.List;

/**
 @author Thomas
 */
public interface IRole
        extends IDomain
{
    List<IPermission> getPermissionList();

    IMember getMember();

    String getName();

    String getDesciption();

    void setName(String name);

    void setMember(IMember member);

    void setPermissionList(List<IPermission> permisssionList);

    void setDescription(String description);
}
