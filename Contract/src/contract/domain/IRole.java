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

    List<IMember> getMembers();

    String getName();

    String getDesciption();

    void setName(String name);

    void setMembers(List<IMember> members);

    void setPermissionList(List<IPermission> permisssionList);

    void setDescription(String description);
}
