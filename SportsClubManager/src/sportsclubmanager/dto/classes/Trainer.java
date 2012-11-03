package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Trainer
        extends Role
        implements Serializable, ITrainer
{
    private List<ClubTeam> clubTeamList = new LinkedList<>();

    Trainer(ITrainer d)
    {
        for (IClubTeam c : d.getClubTeamList())
        {
            clubTeamList.add(new ClubTeam(c));
        }
    }

    @Override
    public List<IClubTeam> getClubTeamList()
    {
        List<IClubTeam> result = new LinkedList<>();

        for (ClubTeam d : clubTeamList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setClubTeamList(List<IClubTeam> clubTeamList)
    {
        List<ClubTeam> result = new LinkedList<>();

        for (IClubTeam d : clubTeamList)
        {
            result.add(new ClubTeam(d));
        }

        this.clubTeamList = result;
    }
}
