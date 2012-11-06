/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Sample;

import java.util.LinkedList;
import java.util.List;
import pipesandfilters.ActiveDataSink;

/**
 *
 * @author Thomas
 */
public class SampleActiveDataSink<T> extends ActiveDataSink<T> {

    private List<T> values = new LinkedList<T>();
    
    public List<T> getValues()
    {
        return values;
    }
    
    @Override
    public void add(T value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
