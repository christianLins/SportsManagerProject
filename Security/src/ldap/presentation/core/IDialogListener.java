package ldap.presentation.core;

import contract.dto.IUserDataDto;

/**
 @author Thomas
 */
public interface IDialogListener
{
    void dialogClosed(DialogResult dialogResult, IUserDataDto userData);
}
