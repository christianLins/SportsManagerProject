package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.List;
import sportsclubmanager.domain.contract.*;

public class ClubTeam extends Team implements Serializable, IClubTeam {
    private List<Department> departmentList;
    private List<Trainer> trainerList;
    private List<Player> playerList;

    @Override
    public List<IDepartment> getDepartmentList()
    {
        return departmentList;
    }

    @Override
    public void setDepartmentList(List<IDepartment> departmentList)
    {
        this.departmentList = departmentList;
    }

    @Override
    public List<ITrainer> getTrainerList()
    {
        return trainerList;
    }

    @Override
    public void setTrainerList(List<ITrainer> trainerList)
    {
        this.trainerList = trainerList;
    }

    @Override
    public List<IPlayer> getPlayerList()
    {
        return playerList;
    }

    @Override
    public void setPlayerList(List<IPlayer> playerList)
    {
        this.playerList = playerList;
    }
}
