/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Interfaces;

/**
 *
 * @author Thomas
 */
public interface IPassiveSink<T> {
    void write(T value);
}
