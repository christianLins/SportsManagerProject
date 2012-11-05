/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.contract;

/**

 @author Thomas
 */
public interface IMatchresult
{
       Integer getId();

       double getPointsForeignteam();

    double getPointsHometeam();

    void setPointsForeignteam(double pointsForeignteam);

    void setPointsHometeam(double pointsHometeam);
}
