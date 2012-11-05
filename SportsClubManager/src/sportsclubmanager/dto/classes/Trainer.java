package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Trainer
        extends Role
        implements Serializable, ITrainer
{
    private List<ClubTeam> clubTeamList = new LinkedList<>();

    public Trainer()
    {
    }
    private static HashMap<ITrainer, Trainer> trainers = new HashMap<>();

    public static Trainer copy(ITrainer trainer)
    {
        Trainer a;

        if (trainers.containsKey(trainer))
        {
            a = trainers.get(trainer);
        }
        else
        {
            a = new Trainer();

            a.setClubTeamList(trainer.getClubTeamList());

            trainers.put(trainer, a);
        }

        return a;
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
            result.add(ClubTeam.copy(d));
        }

        this.clubTeamList = result;
    }
}
