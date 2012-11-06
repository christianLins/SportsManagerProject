/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.io.Serializable;
import java.util.Collection;
import sportsclubmanager.domain.contract.*;

/**

 @author Lins Christian (christian.lins87@gmail.com)
 */
public interface CompetitionService
        extends Serializable
{
    public boolean createCompetition(ICompetition competition, IMember member);

    public boolean removePlayer(IClubTeam team, ITrainer trainer, IPlayer player);

    public boolean addPlayer(IClubTeam team, ITrainer trainer, IPlayer player);

    public boolean createMatchResult(IMatch match, IClubTeam clubTeam, ITrainer trainer, IMatchresult result);

    public Collection<IMatchresult> getMetchresults(ICompetition competition);
}
