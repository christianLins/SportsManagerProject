package serviceClientFactories;


import rmi.client.CommunicationProblemException;
import rmi.client.RmiServiceClientImpl;
import services.ServiceClient;


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
    
    public static  ServiceClient getRmiServiceClient(String host, int port) throws CommunicationProblemException {
        return new RmiServiceClientImpl(host, port);
    }
    
}
