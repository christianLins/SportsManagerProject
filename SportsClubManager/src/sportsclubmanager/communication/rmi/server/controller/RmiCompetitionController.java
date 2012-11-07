/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.communication.rmi.server.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import sportsclubmanager.controller.CompetitionController;
import sportsclubmanager.controller.contract.IdNotFoundException;
import sportsclubmanager.dto.contract.ICompetition;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiCompetitionController extends UnicastRemoteObject implements IRmiCompetitionController
{
    private static RmiCompetitionController INSTANCE;
    
    private RmiCompetitionController() throws RemoteException {
        super();
    }
    
    public static IRmiCompetitionController getInstance() throws RemoteException {
        if(INSTANCE == null) INSTANCE = new RmiCompetitionController();
        return INSTANCE;
    }
    
    
    @Override
    public ICompetition getById(Integer id)
            throws IdNotFoundException
    {
        return CompetitionController.getInstance().getById(id);
    }

    @Override
    public List<ICompetition> getAll()
    {
       return CompetitionController.getInstance().getAll();
    }

    @Override
    public Integer set(ICompetition value)
    {
       return CompetitionController.getInstance().set(value);
    }

    @Override
    public void delete(ICompetition value)
    {
        CompetitionController.getInstance().delete(value);
    }

   
}
