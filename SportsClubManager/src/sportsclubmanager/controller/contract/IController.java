/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller.contract;

import java.util.List;
import sportsclubmanager.controller.IdNotFoundException;

/**

 @author Thomas
 */
public interface IController<T>
{
    T getById(Integer id) throws IdNotFoundException;

    List<T> getAll();

    void set(T value);
}
