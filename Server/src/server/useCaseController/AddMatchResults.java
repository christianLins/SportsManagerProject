/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import contract.IAddMatchResults;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IMatchresult;
import dto.contract.ITeam;
import dto.mapper.*;
import dto.mapper.contract.IdNotFoundException;
import dto.mapper.contract.NotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EnjoX
 */
public class AddMatchResults implements IAddMatchResults {

    private static AddMatchResults  singleton = null;
    DtoFactory access;
    private AddMatchResults() {};
    
    public static AddMatchResults getInstance() {
        if (singleton == null) {
            singleton = new AddMatchResults();
        }
        return singleton;
    }

    @Override
    public List<ICompetition> getCompetitionList() {
        try {
            return DtoFactory.getCompetitionMapper().getAll();
        } catch (RemoteException | NotFoundException ex) {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ITeam> getTeamList(List<Integer> team) {

        List<ITeam> teamList = new ArrayList<>();
        try {
            for (Integer id : team) {

                teamList.add(DtoFactory.getTeamMapper().getById(id));
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
        }

        return teamList;
    }

    @Override
    public List<IMatch> getMatchList(List<Integer> match) {

        List<IMatch> matchList = new ArrayList<>();

        try {
            for (Integer id : match) {
                matchList.add(DtoFactory.getMatchMapper().getById(id));
            }
        } catch (RemoteException | IdNotFoundException ex) {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchList;
    }

    @Override
    public void setMatchResult(IMatch match, IMatchresult matchresult) {
        try {
            Integer matchresultId = DtoFactory.getMatchresultMapper().set(matchresult);
            match.setMatchresult(matchresultId);
            DtoFactory.getMatchMapper().set(match);
        } catch (RemoteException ex) {
            Logger.getLogger(AddMatchResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
