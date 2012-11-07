/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.contract;

import java.util.List;

/**

 @author Thomas
 */
public interface ITypeOfSport extends IDomain
{
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<IPlayer> getPlayerList();

    void setPlayerList(List<IPlayer> playerList);
}
