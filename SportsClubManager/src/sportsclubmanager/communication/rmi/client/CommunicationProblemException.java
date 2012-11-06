/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.client;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
class CommunicationProblemException
        extends Exception
{
    public CommunicationProblemException(String message, java.lang.Exception e)
    {
        super(message, e);
    }
}
