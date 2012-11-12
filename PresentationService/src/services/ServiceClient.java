package services;

import contract.*;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface ServiceClient
{
    
    IAddMatchResults getAddMatchResultsService() throws  ServiceNotAvailableException;
    IChangeCompetitionTeam getChangeCompetitionTeamService() throws ServiceNotAvailableException;
    INewCompetition getNewCompetitionService() throws ServiceNotAvailableException;
    INewMember getNewMemberService() throws ServiceNotAvailableException;
    ISearchChangeMember getSearchChangeMemberService() throws ServiceNotAvailableException;
    IShowCompetition getShowCompetitionService() throws ServiceNotAvailableException;
    
    
}
