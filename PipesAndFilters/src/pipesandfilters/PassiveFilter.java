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
import pipesandfilters.DataObjects.Word;
import pipesandfilters.Interfaces.IWriter;

/**
 *
 * @author Thomas
 */
public abstract class PassiveFilter<in, out> implements IWriter<in>  {

    private ActiveSource<out> pusher;
    private PassiveSink<in> sink;
    
    protected out result;

    public PassiveFilter()
    {
        pusher = new ActiveSource();
        sink = new PassiveSink(this);
    }
    
    public IActiveSource<out> getPusher()
    {
        return pusher;
    }
    
    public IPassiveSink<in> getSink()
    {
        return sink;
    }
    
    public void write(in value) {
        if (filter(value)) {
            pusher.write(result);
            init();
        }
    }

    public abstract void init();
    
    public abstract boolean filter(in value);
}
