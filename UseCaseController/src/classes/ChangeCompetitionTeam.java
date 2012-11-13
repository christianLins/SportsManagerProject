/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import contract.*;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
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
public class ChangeCompetitionTeam implements IChangeCompetitionTeam{
    private static IChangeCompetitionTeam INSTANCE;
    
    private ChangeCompetitionTeam() {
        
    }
    
    public static IChangeCompetitionTeam getInstance() {
        if(INSTANCE == null) INSTANCE = new ChangeCompetitionTeam();
        return INSTANCE;
    }

    @Override
    public List<ICompetition> getCompetition() {
        try {
            return DtoFactory.getCompetitionMapper().getAll();
        } catch (RemoteException ex) {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IClubTeam> getClubTeams(List<Integer> Teams) {
        List<IClubTeam> clubTeamList = new ArrayList<>();

        try {
            for (Integer teamId : Teams) {
                clubTeamList.add(DtoFactory.getClubTeamManager().getById(teamId));
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clubTeamList;
    }

    @Override
    public void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam) {
        List<Integer> teamList = competition.getTeamList();
        
        for(Integer team : teamList)
        {
            if(team == oldTeam.getId())
                team = newTeam.getId();
        }
        try {
            DtoFactory.getCompetitionManager().set(competition);
        } catch (RemoteException ex) {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IClubTeam> getClubTeams()
    {
        try {
            return DtoFactory.getClubTeamManager().getAll();
        } catch (RemoteException ex) {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public IClubTeam getCompetitionTeam(IClubTeam team) {
        //Sry han kA meh was i do tu muss ^^
        return team;
    }

    @Override
    public List<IPlayer> getPlayers(List<Integer> players) {
        List<IPlayer> playerList = new ArrayList<>();
        
        try
        {
            for(Integer player : players)
            {
                playerList.add(DtoFactory.getPlayerManager().getById(player));
            }
        }
        catch(RemoteException | IdNotFoundException ex)
        {
            Logger.getLogger(ChangeCompetitionTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
           return playerList;     
    }
}
