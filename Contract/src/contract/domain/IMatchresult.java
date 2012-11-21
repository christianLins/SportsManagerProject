/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contract.domain;

/**

 @author Thomas
 */
public interface IMatchresult extends IDomain
{
    boolean isFin();
    
    void setFin(boolean fin);
    
    double getPointsForeignteam();

    double getPointsHometeam();

    void setPointsForeignteam(double pointsForeignteam);

    void setPointsHometeam(double pointsHometeam);
}
