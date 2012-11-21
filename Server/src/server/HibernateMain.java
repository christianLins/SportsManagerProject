
import domain.CouldNotFetchException;
import domain.DomainFacade;
import domain.classes.Department;
import domain.classes.Role;
import domain.contract.IDepartment;
import domain.contract.IMember;
import domain.contract.IRole;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.HibernateTestDatabase;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class HibernateMain
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        HibernateTestDatabase test = new HibernateTestDatabase();
        try
        {
            Class[] classes = test.getAllClasses();
            for (Class clazz : classes)
            {
                for (Object obj : DomainFacade.getInstance().getAll(clazz))
                {
                    System.out.println("---------------------------------------");
                    System.out.println(clazz.toString());
                    System.out.println("---------------------------------------");

                    test.iterateGetMethodsOfObject(obj);
                }
            }
        }
        catch (ClassNotFoundException | CouldNotFetchException ex)
        {
            Logger.getLogger(HibernateMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
