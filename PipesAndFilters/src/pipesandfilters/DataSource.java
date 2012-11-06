/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import java.io.*;
import pipesandfilters.Connectors.ActiveSource;
import pipesandfilters.Interfaces.IPassiveSink;
import pipesandfilters.Interfaces.IActiveSource;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;
import pipesandfilters.DataObjects.Char;

/**

 @author Thomas
 */
public abstract class DataSource<T>
        implements Runnable
{
    private ActiveSource<T> pusher = new ActiveSource<T>();

    public IActiveSource<T> getPusher()
    {
        return pusher;
    }

    @Override
    public void run()
    {
        T b = getValue();

        while (!this.isEOF(b))
        {
            pusher.write(b);
            b = getValue();
        }
        
                    pusher.write(b);
    }

    public abstract T getValue();

    public abstract boolean isEOF(T value);
}
