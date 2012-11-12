/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IPlayer;
import dto.mapper.DtoFactory;
import dto.mapper.contract.IdNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author EnjoX
 */
public class ShowCompetition implements IShowCompetition{
    
    private static ShowCompetition INSTANCE;
    
    private ShowCompetition() {
        
    }
    
    public static IShowCompetition getInstance() {
        if(INSTANCE == null) INSTANCE = new ShowCompetition();
        return INSTANCE;
    }

    @Override
    public List<ICompetition> getCompetitions() {
        try {
            return DtoFactory.getCompetitionMapper().getAll();
        } catch (RemoteException ex) {
            Logger.getLogger(ShowCompetition.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<IMatch> getMatchs(List<Integer> matches) {
        List<IMatch> matchList = new ArrayList<>();

        try {
            for (Integer id : matches) {
                matchList.add(DtoFactory.getMatchManager().getById(id));
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(ShowCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public List<ShowMatchObj> getTeams(List<Integer> matches) {
        //return nicht mehr nötig da match in DTO geändert wurde!!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IPlayer> getPlayer(IClubTeam team) {
        List<IPlayer> playerList = new ArrayList<>();
        
        try
        {
            for(Integer playerID : team.getPlayerList())
            {
                playerList.add(DtoFactory.getPlayerManager().getById(playerID));
            }
        }
        catch(RemoteException | IdNotFoundException ex)
        {
            
        }
        return playerList;

    }

   
    
}
