
import database.DatabaseManager;
import domain.CouldNotFetchException;
import domain.DomainFacade;
import domain.contract.IMember;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class HibernateMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            IMember m  = DomainFacade.getInstance().getMemberByUsername("mmo7528");
            System.out.println(m.getUsername());
        }
        catch (CouldNotFetchException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
