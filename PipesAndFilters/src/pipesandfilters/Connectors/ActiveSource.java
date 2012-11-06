/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Connectors;

import java.util.LinkedList;
import java.util.List;
import pipesandfilters.Interfaces.IActiveSource;
import pipesandfilters.Interfaces.IPassiveSink;
import pipesandfilters.Interfaces.IWriter;

/**
 *
 * @author Thomas
 */
public class ActiveSource<T> implements IActiveSource<T>, IWriter<T>{

    private List<IPassiveSink<T>> sinks = new LinkedList<IPassiveSink<T>>();
    
    @Override
    public List<IPassiveSink<T>> getSinks() {
return sinks;
    }

    @Override
    public void addSink(IPassiveSink<T> sink) {
        sinks.add(sink);
    }

    public void write(T value) {
        for(IPassiveSink<T> sink : sinks)
        {
            sink.write(value);
        }
    }
    
}
