package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.IMatch;
import dto.contract.IMatchresult;
import dto.contract.ITeam;
import dto.mapper.DtoFactory;
import dto.mapper.contract.IdNotFoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Match
        implements Serializable, IMatch {

    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Integer competition;
    private Integer matchresult;
    private Integer foreignteam;
    private Integer hometeam;

   public Match() {
    }

    Match(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
    private static HashMap<domain.contract.IMatch, Match> matchs = new HashMap<>();

    public static Match copy(domain.contract.IMatch match) {
        Match a;

        if (matchs.containsKey(match)) {
            a = matchs.get(match);
        } else {
            a = new Match();

            a.setDateFrom(match.getDateFrom());
            a.setDateTo(match.getDateTo());
            a.competition = match.getCompetition().getId();
            a.matchresult = match.getMatchresult().getId();
            a.foreignteam = match.getForeignteam().getId();
            a.hometeam = match.getHometeam().getId();

            matchs.put(match, a);
        }

        return a;
    }

    @Override
    public Date getDateFrom() {
        return dateFrom;
    }

    @Override
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public Date getDateTo() {
        return dateTo;
    }

    @Override
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public Integer getCompetition() {
        return competition;
    }

    @Override
    public void setCompetition(Integer competition) {
        this.competition = competition;
    }

    @Override
    public IMatchresult getMatchresult() {
        try {
            try {
                return DtoFactory.getMatchresultMapper().getById(matchresult);
            } catch (RemoteException ex) {
                Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IdNotFoundException ex) {
            Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setMatchresult(Integer matchresult) {
        this.matchresult = matchresult;
    }

    @Override
    public ITeam getForeignteam() {
        try {
            try {
                return DtoFactory.getTeamMapper().getById(foreignteam);
            } catch (IdNotFoundException ex) {
                Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void setForeignteam(Integer foreignteam) {
        this.foreignteam = foreignteam;
    }

    @Override
    public ITeam getHometeam() {
        try {
            try {
                return DtoFactory.getTeamMapper().getById(hometeam);
            } catch (IdNotFoundException ex) {
                Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Match.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setHometeam(Integer hometeam) {
        this.hometeam = hometeam;
    }
}
