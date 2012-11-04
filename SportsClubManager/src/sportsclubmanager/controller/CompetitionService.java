/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.io.Serializable;
import java.util.Collection;
import sportsclubmanager.domain.classes.Matchresult;

/**
 * 
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface CompetitionService extends Serializable
{
    
    public boolean createCompetition();
    public boolean removePlayer();
    public boolean addPlayer();
    public boolean createMatchResult();
    public Collection<Matchresult> getMetchresult();
    
    
}
