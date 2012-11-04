/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.client;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
class CommunicationProblemException extends Exception
{

    public CommunicationProblemException(java.lang.Exception e)
    {
        super("Connection could not be established", e);
    }
    
}
