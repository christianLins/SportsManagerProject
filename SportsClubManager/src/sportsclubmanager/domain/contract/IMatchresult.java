/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

/**

 @author Thomas
 */
public interface IMatchresult extends IDomain
{
    double getPointsForeignteam();

    double getPointsHometeam();

    void setPointsForeignteam(double pointsForeignteam);

    void setPointsHometeam(double pointsHometeam);
}
