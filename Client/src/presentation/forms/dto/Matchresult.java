/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.forms.dto;

import contract.dto.IMatchresultDto;

/**
 *
 * @author Lucia
 */
public class Matchresult implements IMatchresultDto {

    private int id;
    private boolean fin;
    private double pointsHometeam;
    private double pointsForeignteam;

    @Override
    public double getPointsHometeam() {
        return pointsHometeam;
    }

    @Override
    public void setPointsHometeam(double pointsHometeam) {
        this.pointsHometeam = pointsHometeam;
    }

    @Override
    public double getPointsForeignteam() {
        return pointsForeignteam;
    }

    @Override
    public void setPointsForeignteam(double pointsForeignteam) {
        this.pointsForeignteam = pointsForeignteam;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean IsFinal() {
        return this.fin;
    }
}
