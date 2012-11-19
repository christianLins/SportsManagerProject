/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.classes;

import dto.contract.IAdmin;
import java.util.HashMap;

/**
 @author Thomas
 */
public class Admin
        extends Role
        implements IAdmin
{
    private static HashMap<domain.contract.IAdmin, Admin> admins = new HashMap<>();

    public static Admin copy(domain.contract.IAdmin admin)
    {
        Admin a;

        if (admins.containsKey(admin))
        {
            a = admins.get(admin);
        }
        else
        {
            a = copy(admin, new Admin());

            admins.put(admin, a);
        }

        return a;
    }
}
