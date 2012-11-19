package dto.classes;

import java.io.Serializable;
import java.util.HashMap;
import dto.contract.IMatchresult;

public class Matchresult
        implements Serializable, IMatchresult
{
    private int id;
    private boolean fin;
    private double pointsHometeam;
    private double pointsForeignteam;

    public Matchresult()
    {
    }

    Matchresult(int id)
    {
        this.id = id;
    }
    private static HashMap<domain.contract.IMatchresult, Matchresult> matchresults = new HashMap<>();

    public static Matchresult copy(domain.contract.IMatchresult matchresult)
    {
        Matchresult a;

        if (matchresults.containsKey(matchresult))
        {
            a = matchresults.get(matchresult);
        }
        else
        {
            a = new Matchresult(matchresult.getId());

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

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public boolean IsFinal()
    {
        return this.fin;
    }
}
