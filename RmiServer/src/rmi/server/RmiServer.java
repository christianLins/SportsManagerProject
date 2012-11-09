/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.contract.RmiServiceClient;

/**
 * runnable rmi-server
 *
 * start it - if possible - in a seperate thread
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServer
        implements Runnable {

    private final int port;
    private boolean isRunning;

    /**
     * RMI server to enable client-server communiation over rmi
     *
     * @param port where server runs locally
     */
    public RmiServer(int port) {
        this.port = port;
    }

    /**
     * starts the rmi-server
     *
     * check server after start if it really runs!
     *
     * <code>isRunning()
     * <code>
     */
    @Override
    public void run() {
        try {
            // start rmiregistry
            LocateRegistry.createRegistry(port);

            // set the codebase
            String cb = RmiServer.class.getProtectionDomain().getCodeSource().getLocation().getFile();
            System.setProperty("java.rmi.server.codebase", "file://" + cb);


            RmiServiceClient rmiServiceFactory = new RmiServiceClientFactory();
            Naming.rebind("rmi://localhost:" + port + "/CommunicationFactory", rmiServiceFactory);
            isRunning = true;
            System.out.println("rmi server is running on port " + port);
        } catch (RemoteException | MalformedURLException ex) {
            // throw new RmiServerException(ex);
        }
    }

    /**
     * check, if rmi-server is running
     *
     * @return
     */
    public boolean isRunning() {
        return isRunning;
    }

   
}
