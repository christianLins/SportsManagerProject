/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import pipesandfilters.Connectors.*;
import pipesandfilters.Interfaces.*;

/**
 *
 * @author Thomas
 */
public abstract class ActiveFilter<T,U> implements Runnable{

    private ActiveSource<U> pusher;
    
    private ActiveSink<T> puller;
    
    private U result;
    
    public ActiveFilter()
    {
        pusher =new ActiveSource<>();
        puller = new ActiveSink<>();
    }
    public IActiveSource<U> getPusher()
    {
        return pusher;
    }
    
    public IActiveSink<T> getPuller()
    {
        return puller;
    }

    @Override
    public void run() {
       T rawValue = puller.read();
       if(filter(rawValue))
       {
           pusher.write(result);
    }
    }
    
    public abstract boolean filter(T rawValue);
}
