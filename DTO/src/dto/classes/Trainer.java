package dto.classes;

import java.io.Serializable;
import java.util.*;
import dto.contract.ITrainer;

public class Trainer
        extends Role
        implements Serializable, ITrainer
{
    private List<Integer> clubTeamList = new LinkedList<>();
    private List<Integer> typeOfSportList = new LinkedList<>();

    Trainer(int id)
    {
        super(id);
    }
    private static HashMap<domain.contract.ITrainer, Trainer> trainers = new HashMap<>();

    public static Trainer copy(domain.contract.ITrainer trainer)
    {
        Trainer a;

        if (trainers.containsKey(trainer))
        {
            a = trainers.get(trainer);
        }
        else
        {
            a = new Trainer(trainer.getId());

            List<Integer> clubTeamList = new LinkedList<>();

            for (domain.contract.IClubTeam c : trainer.getClubTeamList())
            {
                clubTeamList.add(c.getId());
            }

            a.setClubTeamList(clubTeamList);

            List<Integer> typeOfSportList = new LinkedList<>();

            for (domain.contract.ITypeOfSport t : trainer.getTypeOfSportList())
            {
                typeOfSportList.add(t.getId());
            }
            a.setTypeOfSportList(typeOfSportList);

            trainers.put(trainer, a);
        }

        return a;
    }

    Trainer()
    {
    }

    @Override
    public List<Integer> getClubTeamList()
    {
        return clubTeamList;
    }

    @Override
    public void setClubTeamList(List<Integer> clubTeamList)
    {
        this.clubTeamList = clubTeamList;
    }

    @Override
    public List<Integer> getTypeOfSportList()
    {
        return typeOfSportList;
    }

    @Override
    public void setTypeOfSportList(List<Integer> typeOfSportList)
    {
        this.typeOfSportList = typeOfSportList;
    }
}
