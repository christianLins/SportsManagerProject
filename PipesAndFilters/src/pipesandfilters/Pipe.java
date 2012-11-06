/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import pipesandfilters.Connectors.ActiveSource;
import pipesandfilters.Connectors.PassiveSink;
import pipesandfilters.Interfaces.IPassiveSink;
import pipesandfilters.Interfaces.IActiveSource;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class Pipe<T> {
    private ActiveSource<T> pusher;
    private PassiveSink<T> sink;

    public Pipe()
    {
        pusher = new ActiveSource<T>();
        sink = new PassiveSink<T>(pusher);
    }
    
    public IActiveSource<T> getPusher()
    {
        return pusher;
    }

    public IPassiveSink<T> getSink()
    {
        return sink;
    }
}
