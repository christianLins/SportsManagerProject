/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

import java.util.List;

/**
 @author Thomas
 */
public interface IRole
        extends IDto
{
    List<Integer> getPermisssionList();

    void setPermisssionList(List<Integer> permisssionList);
}
