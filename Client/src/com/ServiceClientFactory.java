package com;

import com.ServiceClient;
import com.CommunicationProblemException;
import com.rmi.client.RmiServiceClientImpl;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class ServiceClientFactory
{
    public static ServiceClient getRmiServiceClient(String host, int port)
            throws CommunicationProblemException
    {
        return new RmiServiceClientImpl(host, port);
    }
}
