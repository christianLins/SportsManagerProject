/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.contract;

/**

 @author Thomas
 */
public interface IMatchresult
        extends IDto
{
    double getPointsForeignteam();

    double getPointsHometeam();

    void setPointsForeignteam(double pointsForeignteam);

    void setPointsHometeam(double pointsHometeam);

    public boolean IsFinal();
}
