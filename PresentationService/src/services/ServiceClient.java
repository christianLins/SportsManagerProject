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
    
    IAddMatchResults getAddMatchResultsService();
    IChangeCompetitionTeam getChangeCompetitionTeamService();
    INewCompetition getNewCompetitionService();
    INewMember getNewMemberService();
    ISearchChangeMember getSearchChangeMemberService();
    IShowCompetition getShowCompetitionService();
    
    
}
