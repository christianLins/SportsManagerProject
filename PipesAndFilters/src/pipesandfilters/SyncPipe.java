/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import pipesandfilters.Connectors.*;
import pipesandfilters.Interfaces.*;

/**

 @author Thomas
 */
public class SyncPipe<T>
        implements IReader<T>, IWriter<T>
{
    private IPassiveSource<T> source;
    private IPassiveSink<T> sink;

    public SyncPipe()
    {
        source = new PassiveSource<>(this);
        sink = new PassiveSink<>(this);
    }

    public IPassiveSource<T> getSource()
    {
        return source;
    }

    public IPassiveSink<T> getSink()
    {
        return sink;
    }

    @Override
    public T read()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void write(T value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
