/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.ICaretaker;
import java.util.HashMap;

/**
 @author Thomas
 */
public class Caretaker
        extends Role
        implements ICaretaker
{
    public Caretaker()
    {
        super();

        this.setName("Caretaker");
        this.setDescription("Caretaker");
    }
    private static HashMap<contract.domain.ICaretaker, Caretaker> admins = new HashMap<>();

    public static Caretaker copy(contract.domain.ICaretaker admin)
    {
        Caretaker a;

        if (admins.containsKey(admin))
        {
            a = admins.get(admin);
        }
        else
        {
            a = copy(admin, new Caretaker());

            admins.put(admin, a);
        }

        return a;
    }
}
