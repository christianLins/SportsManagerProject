/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.ITeamDto;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lucia
 */
public class Team implements ITeamDto{
    
    private int id;
    private String name;
    private String description;
    private List<Integer> competitionList = new LinkedList<>();
    private List<Integer> matchList = new LinkedList<>();
    private Integer league;

    @Override
    public List<Integer> getCompetitionList() {
        return competitionList;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Integer getLeague() {
        return league;
    }

    @Override
    public List<Integer> getMatchList() {
        return matchList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCompetitionList(List<Integer> competitionList) {
        this.competitionList = competitionList;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setLeague(Integer league) {
        this.league = league;
    }

    @Override
    public void setMatchList(List<Integer> matchList) {
        this.matchList = matchList;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }
    
}
