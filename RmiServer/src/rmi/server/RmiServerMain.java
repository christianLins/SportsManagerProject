package rmi.server;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class RmiServerMain
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        
        
        // start rmi-server-thread --------------------------------------------
        RmiServer rmiServer = new RmiServer(1099);
        new Thread(rmiServer).start();
        if (rmiServer.isRunning()) System.out.println("RMI Server is running");
        // --------------------------------------------------------------------
    }
}
