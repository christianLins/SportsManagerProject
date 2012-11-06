/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Connectors;

import pipesandfilters.Interfaces.IPassiveSink;
import pipesandfilters.Interfaces.IWriter;

/**
 *
 * @author Thomas
 */
public class PassiveSink<T> implements IPassiveSink<T>{

    private IWriter<T> writer;
    
    public PassiveSink(IWriter<T> writer)
    {
        this.writer = writer;
    }
    
    @Override
    public void write(T value) {
      writer.write(value);
    }   
}
