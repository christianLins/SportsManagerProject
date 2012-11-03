package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class Trainer extends Role implements Serializable, ITrainer {
    private List<ClubTeam> clubTeamList;

    @Override
    public List<IClubTeam> getClubTeamList()
    {
        return clubTeamList;
    }

    @Override
    public void setClubTeamList(List<IClubTeam> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }
}
