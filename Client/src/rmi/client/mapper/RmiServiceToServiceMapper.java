/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

/**
 interface for all mappers between rmi and presentation

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface RmiServiceToServiceMapper<RmiService, Service>
{
    Service getService(RmiService rmiService);
}
