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
public class ActiveSink<T> implements IActiveSink<T>, IReader<T> {

    private IPassiveSource<T> source;
    
    @Override
    public IPassiveSource<T> getSource() {
       return source;
    }

    @Override
    public void setSource(IPassiveSource<T> source) {
        this.source = source;
    }

    @Override
    public T read() {
       return source.read();
    }
}
