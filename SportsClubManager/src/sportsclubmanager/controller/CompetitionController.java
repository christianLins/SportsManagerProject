/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.controller;

import java.util.*;
import sportsclubmanager.domain.classes.*;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class CompetitionController implements CompetitionService
{
    
    public static CompetitionController getInstance() {
        // implement as singleton
        return null;
    }

    @Override
    public boolean createCompetition()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removePlayer()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addPlayer()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean createMatchResult()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Matchresult> getMetchresult()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
