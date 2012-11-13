/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap.presentation.core;

import dto.contract.IUserData;

/**

 @author Thomas
 */
public interface IDialogListener
{
    void dialogClosed(DialogResult dialogResult, IUserData userData);
}
