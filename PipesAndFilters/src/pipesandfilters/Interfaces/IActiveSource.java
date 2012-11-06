/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Interfaces;

import java.util.List;

/**
 *
 * @author Thomas
 */
public interface IActiveSource<T> {

    List<IPassiveSink<T>> getSinks();

    void addSink(IPassiveSink<T> sink);
}
