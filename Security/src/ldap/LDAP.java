/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldap;

/**

 @author Thomas
 */
public class LDAP
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        UserData userData = new UserData("Hallo", "test", "localhost");

        if (new Authenticator().auth(userData))
        {
            System.out.println("access granted");
        }
        else
        {
            System.out.println("invalid user or password");
        }
    }
}
