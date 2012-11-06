/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import pipesandfilters.Connectors.ActiveSink;
import pipesandfilters.Interfaces.IActiveSink;

/**
 *
 * @author Thomas
 */
public abstract class ActiveDataSink<T> implements Runnable{

    private ActiveSink<T>  puller= new ActiveSink<T>();

    public IActiveSink<T> getPuller()
    {
        return puller;
    }

    public abstract void add(T value);
    
    @Override
    public void run() {
        T value = puller.read();
        add(value);
    }
}
