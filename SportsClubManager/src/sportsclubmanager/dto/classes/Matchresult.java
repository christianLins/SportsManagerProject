package sportsclubmanager.dto.classes;

import java.io.Serializable;
import java.util.*;
import sportsclubmanager.domain.contract.*;

public class Matchresult
        implements Serializable, IMatchresult
{
    private double pointsHometeam;
    private double pointsForeignteam;

    public Matchresult()
    {
    }
    private static HashMap<IMatchresult, Matchresult> matchresults = new HashMap<>();

    public static Matchresult copy(IMatchresult matchresult)
    {
        Matchresult a;

        if (matchresults.containsKey(matchresult))
        {
            a = matchresults.get(matchresult);
        }
        else
        {
            a = new Matchresult();

            a.setPointsHometeam(matchresult.getPointsHometeam());
            a.setPointsForeignteam(matchresult.getPointsForeignteam());

            matchresults.put(matchresult, a);
        }

        return a;
    }

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
