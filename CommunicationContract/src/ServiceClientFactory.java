
import rmi.client.RmiServiceClient;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ServiceClientFactory
{
    
    public static ServiceClient getServiceClient() {
        new RmiServiceClient();
        return null;
    }
    
}
