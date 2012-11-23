/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import java.util.HashMap;
import contract.dto.IAdmin;

/**
 @author Thomas
 */
public class Admin
        extends Role
        implements IAdmin
{
    public Admin()
    {
        super();

        this.setName("Admin");
        this.setDescription("Admin");
    }
    private static HashMap<contract.domain.IAdmin, Admin> admins = new HashMap<>();

    public static Admin copy(contract.domain.IAdmin admin)
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
