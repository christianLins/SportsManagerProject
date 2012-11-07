/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server.controller;

import java.util.List;
import sportsclubmanager.dto.controller.contract.IdNotFoundException;
import sportsclubmanager.dto.contract.ICompetition;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface IRmiCompetitionController
{
    void delete(ICompetition value);

    List<ICompetition> getAll();

    ICompetition getById(Integer id) throws IdNotFoundException;

    Integer set(ICompetition value);
}
