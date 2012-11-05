package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class ClubTeam
        extends Team
        implements Serializable, IClubTeam
{
    private List<Department> departmentList = new LinkedList<>();
    private List<Trainer> trainerList = new LinkedList<>();
    private List<Player> playerList = new LinkedList<>();

    public ClubTeam()
    {
        super();
    }
    private static HashMap<IClubTeam, ClubTeam> clubTeams = new HashMap<>();

    public static ClubTeam copy(IClubTeam clubTeam)
    {
        ClubTeam a;

        if (clubTeams.containsKey(clubTeam))
        {
            a = clubTeams.get(clubTeam);
        }
        else
        {
            a = new ClubTeam();

            a.setDepartmentList(clubTeam.getDepartmentList());
            a.setTrainerList(clubTeam.getTrainerList());
            a.setPlayerList(clubTeam.getPlayerList());

            clubTeams.put(clubTeam, a);
        }

        return a;
    }

    @Override
    public List<IDepartment> getDepartmentList()
    {
        List<IDepartment> result = new LinkedList<>();

        for (Department d : departmentList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setDepartmentList(List<IDepartment> departmentList)
    {
        List<Department> result = new LinkedList<>();

        for (IDepartment d : departmentList)
        {
            result.add(Department.copy(d));
        }

        this.departmentList = result;
    }

    @Override
    public List<ITrainer> getTrainerList()
    {
        List<ITrainer> result = new LinkedList<>();

        for (Trainer d : trainerList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setTrainerList(List<ITrainer> trainerList)
    {

        List<Trainer> result = new LinkedList<>();

        for (ITrainer d : trainerList)
        {
            result.add(Trainer.copy(d));
        }

        this.trainerList = result;
    }

    @Override
    public List<IPlayer> getPlayerList()
    {
        List<IPlayer> result = new LinkedList<>();

        for (Player d : playerList)
        {
            result.add(d);
        }

        return result;
    }

    @Override
    public void setPlayerList(List<IPlayer> playerList)
    {
        List<Player> result = new LinkedList<>();

        for (IPlayer d : playerList)
        {
            result.add(Player.copy(d));
        }

        this.playerList = result;
    }
}
