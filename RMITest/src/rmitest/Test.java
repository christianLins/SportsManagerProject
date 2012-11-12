/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitest;

import contract.IAddMatchResults;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.client.CommunicationProblemException;
import serviceClientFactories.ServiceClientFactory;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class Test
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        IAddMatchResults addMatchResultsService = null;
        try
        {
            services.ServiceClient client = ServiceClientFactory.getRmiServiceClient("localhost", 1099);
            System.out.println("hallo rmi1");
            addMatchResultsService = client.getAddMatchResultsService();
            System.out.println("hallo rmi2");
            addMatchResultsService.getCompetitionList();
            System.out.println("hallo rmi3");
        }
        catch (CommunicationProblemException ex)
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ServiceNotAvailableException ex)
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
        }
    }
}
