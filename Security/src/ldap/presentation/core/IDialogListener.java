package ldap.presentation.core;

import contract.dto.IUserData;

/**
 @author Thomas
 */
public interface IDialogListener
{
    void dialogClosed(DialogResult dialogResult, IUserData userData);
}
