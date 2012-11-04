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
public interface ILeague
{
    String getDescription();

    String getName();

    @XmlTransient
    List<ITeam> getTeamList();

    void setDescription(String description);

    void setName(String name);

    void setTeamList(List<ITeam> teamList);
}
