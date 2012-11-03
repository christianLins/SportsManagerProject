package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class Team
        implements Serializable, ITeam
{
    private String name;
    private String description;
    private List<Competition> competitionList;
    private ClubTeam clubTeam;
    private List<Match> matchList;
    private League league;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<ICompetition> getCompetitionList()
    {
        return competitionList;
    }

    public void setCompetitionList(List<ICompetition> competitionList)
    {
        // TODO clone methode missing
        this.competitionList = competitionList;
    }

    public IClubTeam getClubTeam()
    {
        return clubTeam;
    }

    public void setClubTeam(IClubTeam clubTeam)
    {
        // TODO clone methode missing
        this.clubTeam = clubTeam;
    }

    public List<IMatch> getMatchList()
    {
        return matchList;
    }

    public void setMatchList(List<IMatch> matchList)
    {
        // TODO clone methode missing
        this.matchList = matchList;
    }

    public ILeague getLeague()
    {
        return league;
    }

    public void setLeague(ILeague league)
    {
        // TODO clone methode missing
        this.league = league;
    }
}
