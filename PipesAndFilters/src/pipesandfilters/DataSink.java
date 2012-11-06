/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import java.util.*;
import pipesandfilters.Connectors.PassiveSink;
import pipesandfilters.Interfaces.*;

/**

 @author Thomas
 */
public class DataSink<T>
        implements IWriter<T>
{
    private IPassiveSink<T> sink;

    public DataSink()
    {
        sink = new PassiveSink<>(this);
    }
    private List<T> values = new LinkedList<>();

    public List<T> getValues()
    {
        return values;
    }

    @Override
    public void write(T value)
    {
        this.values.add(value);
    }

    public IPassiveSink<T> getSink()
    {
        return sink;
    }
}
