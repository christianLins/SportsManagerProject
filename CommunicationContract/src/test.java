/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import contract.IAddMatchResults;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import rmi.client.CommunicationProblemException;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class test
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ServiceNotAvailableException
    {
        try
        {
            services.ServiceClient client = serviceClientFactories.ServiceClientFactory.getRmiServiceClient("localhost", 1099);
            System.out.println("hallo rmi1");
            IAddMatchResults addMatchResultsService = client.getAddMatchResultsService();
            System.out.println("hallo rmi2");
            addMatchResultsService.getCompetitionList();
            System.out.println("hallo rmi3");
        }
        catch (CommunicationProblemException ex)
        {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
