/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server.controller;

import dto.mapper.contract.IMapper;
import dto.mapper.contract.IdNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import dto.contract.ICompetition;
import dto.mapper.DtoFactory;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiCompetitionController
        extends UnicastRemoteObject
        implements IRmiCompetitionController
{
    private static RmiCompetitionController INSTANCE;
    private IMapper<ICompetition> competitionController;

    private RmiCompetitionController()
            throws RemoteException
    {
        super();
        competitionController = DtoFactory.getCompetitionMapper();
    }

    public static IRmiCompetitionController getInstance()
            throws RemoteException
    {
        if (INSTANCE == null)
        {
            INSTANCE = new RmiCompetitionController();
        }
        return INSTANCE;
    }

    @Override
    public ICompetition getById(Integer id)
            throws IdNotFoundException
    {
        return competitionController.getById(id);
    }

    @Override
    public List<ICompetition> getAll()
    {
        return competitionController.getAll();
    }

    @Override
    public Integer set(ICompetition value)
    {
        return competitionController.set(value);
    }

    @Override
    public void delete(ICompetition value)
    {
        competitionController.delete(value);
    }
}
