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

    public ClubTeam(IClubTeam c)
    {
        super(c);

        for (IDepartment d : c.getDepartmentList())
        {
            this.departmentList.add(new Department(d));
        }

        for (ITrainer d : c.getTrainerList())
        {
            this.trainerList.add(new Trainer(d));
        }

        for (IPlayer d : c.getPlayerList())
        {
            this.playerList.add(new Player(d));
        }
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
            result.add(new Department(d));
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
            result.add(new Trainer(d));
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
            result.add(new Player(d));
        }

        this.playerList = result;
    }
}
