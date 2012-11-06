/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sportsclubmanager.domain.CouldNotSaveException;
import sportsclubmanager.domain.DomainFacade;
import sportsclubmanager.domain.classes.Competition;
import sportsclubmanager.domain.classes.Match;
import sportsclubmanager.domain.contract.*;


/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class CompetitionController implements CompetitionService {

    private CompetitionController() {
    }
    ;
    static CompetitionController singleton = null;

    public static CompetitionController getInstance() {
        if (singleton == null) {
            singleton = new CompetitionController();
        }

        return singleton;
    }

    @Override
    public boolean createCompetition(ICompetition competition, IMember member) {
        //TODO hat Recht um competition zu erstellen

        List<IRole> roleList = member.getRoleList();
        for (IRole role : roleList) {
            role.getPermisssionList();
        }

        try {
            DomainFacade.set(competition);
            return true;
        } catch (CouldNotSaveException ex) {
            Logger.getLogger(CompetitionController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean removePlayer(IClubTeam team, ITrainer trainer, IPlayer player) {

        if (team.getTrainerList().contains(trainer)) 
        {
            List<IPlayer> playerList = team.getPlayerList();
            IPlayer playerToRemove = null;
            for (IPlayer pla : playerList) {
                if (pla.equals(player)) { //muss noch gestestet werden ob equals hier funktioniert
                    playerToRemove = pla;
                }
            }
            
            if(playerToRemove != null)
                playerList.remove(playerToRemove);

            try {
                DomainFacade.set(playerList);
                return true;
            } catch (CouldNotSaveException ex) {
                Logger.getLogger(CompetitionController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean addPlayer(IClubTeam team, ITrainer trainer, IPlayer player) {

        if (team.getTrainerList().contains(trainer)) {
            try {
                DomainFacade.set(team.getPlayerList().add(player));
                return true;
            } catch (CouldNotSaveException ex) {
                Logger.getLogger(CompetitionController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean createMatchResult(IMatch match, IClubTeam clubTeam, ITrainer trainer, IMatchresult result) {
        if(clubTeam.getTrainerList().contains(trainer)) //hier homeTeam auf IClubteam damit trainer erlmittelt werden kann?
        {
        match.setMatchresult(result);
        try {
            DomainFacade.set(match);
            return true;
        } catch (CouldNotSaveException ex) {
            Logger.getLogger(CompetitionController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }
        return false;
    }

    @Override
    public Collection<IMatchresult> getMetchresults(ICompetition competition) {

        ArrayList<Match> matchList = DomainFacade.getMatchesByCompetition((Competition) competition);
        Collection<IMatchresult> returnCollection = new ArrayList<>();

        for (Match ma : matchList) {
            returnCollection.add(ma.getMatchresult()); //auch matches ohne ergebnis werden mitgeliefert!!
        }

        return returnCollection;
    }
}
