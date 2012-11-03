/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.*;
import javax.xml.bind.annotation.*;

/**

 @author Thomas
 */
public interface IMatchresult
{
    double getPointsForeignteam();

    double getPointsHometeam();

    void setPointsForeignteam(double pointsForeignteam);

    void setPointsHometeam(double pointsHometeam);
}
