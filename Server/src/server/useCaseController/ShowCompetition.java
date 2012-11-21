/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.useCaseController;

import contract.dto.*;
import contract.dto.mapper.*;
import contract.useCaseController.IShowCompetition;
import java.rmi.RemoteException;
import java.util.*;
import java.util.logging.*;
import server.dto.mapper.DtoFactory;

/**

 @author EnjoX
 */
public class ShowCompetition
        implements IShowCompetition
{
    private static ShowCompetition INSTANCE;

    private ShowCompetition()
    {
    }

    public static IShowCompetition getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ShowCompetition();
        }
        return INSTANCE;
    }

    @Override
    public List<ICompetition> getCompetitions()
    {
        try
        {
            return DtoFactory.getCompetitionMapper().getAll();
        }
        catch (RemoteException | NotFoundException ex)
        {
            Logger.getLogger(ShowCompetition.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<IMatch> getMatchs(List<Integer> matches)
    {
        List<IMatch> matchList = new ArrayList<>();

        try
        {
            for (Integer id : matches)
            {
                matchList.add(DtoFactory.getMatchMapper().getById(id));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(ShowCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public List<IPlayer> getPlayer(IClubTeam team)
    {
        List<IPlayer> playerList = new ArrayList<>();

        try
        {
            for (Integer playerID : team.getPlayerList())
            {
                playerList.add(DtoFactory.getPlayerMapper().getById(playerID));
            }
        }
        catch (RemoteException | IdNotFoundException ex)
        {
        }
        return playerList;

    }
}
