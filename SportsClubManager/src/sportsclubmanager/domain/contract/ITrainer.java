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
public interface ITrainer
{
    @XmlTransient
    List<IClubTeam> getClubTeamList();

    void setClubTeamList(List<IClubTeam> clubTeamList);
}
