/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public interface SeviceClient
{
    
  // Use case controller schnittstellen definieren
    
     IAddMatchResults getAddMatchResultsController();
     IChangeCompetitionTeam getChangeCompetitionTeamController();
     INewCompetition getNewCompetitionController();
     INewMember getNewMemberController();
     ISearchChangeMember getSearchChangeMemberController();
     IShowCompetition getShowCompetitionController();
    
}
