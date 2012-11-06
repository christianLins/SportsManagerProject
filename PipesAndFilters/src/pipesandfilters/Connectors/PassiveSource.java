/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Connectors;

import pipesandfilters.Interfaces.*;

/**
 *
 * @author Thomas
 */
public class PassiveSource<T> implements IPassiveSource<T> {

    IReader<T> reader;
    
    public PassiveSource(IReader<T> reader)
    {
        this.reader = reader;
    }
    @Override
    public T read() {
        return reader.read();
    }
    
}
