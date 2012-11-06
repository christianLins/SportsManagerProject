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
public interface IActiveSink<T> {
        IPassiveSource<T> getSource();

        void setSource(IPassiveSource<T> sink);
}
