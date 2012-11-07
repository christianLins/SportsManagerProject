/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
class RmiServerException
        extends Exception
{
    public RmiServerException(java.io.IOException ex)
    {
        super("Rmi could not be started", ex);
    }
}
