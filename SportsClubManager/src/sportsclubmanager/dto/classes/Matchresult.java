package sportsclubmanager.dto.classes;

import java.io.Serializable;
import sportsclubmanager.domain.contract.IMatchresult;

public class Matchresult implements Serializable, IMatchresult {
    private double pointsHometeam;
    private double pointsForeignteam;

    @Override
    public double getPointsHometeam()
    {
        return pointsHometeam;
    }

    @Override
    public void setPointsHometeam(double pointsHometeam)
    {
        this.pointsHometeam = pointsHometeam;
    }

    @Override
    public double getPointsForeignteam()
    {
        return pointsForeignteam;
    }

    @Override
    public void setPointsForeignteam(double pointsForeignteam)
    {
        this.pointsForeignteam = pointsForeignteam;
    }
}
