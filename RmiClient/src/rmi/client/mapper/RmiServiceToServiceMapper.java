/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface RmiServiceToServiceMapper<RmiService,Service>
{
    Service getService(RmiService rmiService);
    
}
