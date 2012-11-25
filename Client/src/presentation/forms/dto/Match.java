/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IMatchDto;
import contract.dto.IMatchresultDto;
import contract.dto.ITeamDto;
import java.util.Date;

/**
 *
 * @author Lucia
 */
public class Match implements IMatchDto{
    
    private int id;
    private Date dateFrom;
    private Date dateTo;
    private Integer competition;
    private Integer matchresult;
    private Integer foreignteam;
    private Integer hometeam;

    @Override
    public Integer getCompetition() {
        return competition;
    }

    @Override
    public Date getDateFrom() {
        return dateFrom;
    }

    @Override
    public Date getDateTo() {
        return dateTo;
    }

    @Override
    public ITeamDto getForeignteam() {
        //TODO return ITeamDto foreignteam 
        
        //TODO 4 tests only
        ITeamDto foreign = new Team();
        foreign.setName("Foreign");
        
        return foreign;
    }

    @Override
    public ITeamDto getHometeam() {
        //TODO return ITeamDto hometeam
        
        //TODO 4 tests only
        ITeamDto home = new Team();
        home.setName("Home");
        return home;
    }

    @Override
    public IMatchresultDto getMatchresult() {
        
        //TODO return IMachresultDto
        return null;
    }

    @Override
    public void setCompetition(Integer competition) {
        this.competition = competition;
    }

    @Override
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Override
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public void setForeignteam(Integer foreignteam) {
        this.foreignteam = foreignteam;
    }

    @Override
    public void setHometeam(Integer hometeam) {
        this.hometeam = hometeam;
    }

    @Override
    public void setMatchresult(Integer matchresult) {
        this.matchresult = matchresult;
    }

    @Override
    public Integer getId() {
        return id;
    }
    
}
