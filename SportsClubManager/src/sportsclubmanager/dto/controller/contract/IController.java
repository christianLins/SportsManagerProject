/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.controller.contract;

import java.io.Serializable;
import java.util.List;

/**
 @author Thomas
 */
public interface IController<T> extends Serializable
{
    T getById(Integer id) throws IdNotFoundException;

    List<T> getAll();

    Integer set(T value);
    
    void delete(T value);
}
