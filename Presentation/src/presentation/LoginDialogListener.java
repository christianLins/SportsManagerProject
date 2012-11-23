/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import contract.dto.*;
import contract.useCaseController.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import ldap.contract.IAuthenticator;
import ldap.presentation.core.*;
import services.*;

/**

 @author Thomas
 */
public class LoginDialogListener
        implements IDialogListener
{
    @Override
    public void dialogClosed(DialogResult dialogResult, IUserDataDto userData)
    {
        if (!dialogResult.equals(DialogResult.Ok))
        {
            JOptionPane.showMessageDialog(null, "Access denied!");
            return;
        }
        IAuthenticator a = new ldap.Authenticator();

        if (!a.auth(userData))
        {
            JOptionPane.showMessageDialog(null, "Access denied!");
            return;
        }

        try
        {
            JOptionPane.showMessageDialog(null, "Access granted!");

            ServiceClient client = serviceClientFactories.ServiceClientFactory.getRmiServiceClient(userData.getIP(), 1099);
            ILogin loginService = client.getLoginService();
            IMemberDto user = loginService.getMemberByUserData(userData);
            SCM_Overview manager = new SCM_Overview(null, client, user);
            manager.setVisible(true);
        }
        catch (MemberNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Invalid user name");
            //Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (CommunicationProblemException ex)
        {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ServiceNotAvailableException ex)
        {
            Logger.getLogger(SCM_Overview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
