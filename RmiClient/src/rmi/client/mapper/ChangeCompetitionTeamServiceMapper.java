/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.IChangeCompetitionTeam;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import dto.contract.IPlayer;
import java.util.List;
import rmi.contract.services.IAddMatchResultsRmiService;
import rmi.contract.services.IChangeCompetitionTeamRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class ChangeCompetitionTeamServiceMapper implements RmiServiceToServiceMapper<IChangeCompetitionTeamRmiService, IChangeCompetitionTeam>
{

    @Override
    public IChangeCompetitionTeam getService(IChangeCompetitionTeamRmiService rmiService)
    {
        ChangeCompetitionTeam n = new ChangeCompetitionTeam();
        n.setService(rmiService);
        return n;  
    }
    
    class ChangeCompetitionTeam implements IChangeCompetitionTeam {
        
        private IChangeCompetitionTeamRmiService service;
        
        
        public void setService(IChangeCompetitionTeamRmiService service) {
            this.service = service;
        }

        @Override
        public List<ICompetition> getCompetition()
        {
            return service.getCompetition();
        }

        @Override
        public List<IClubTeam> getClubTeams(List<Integer> Teams)
        {
            return service.getClubTeams(Teams);
        }

        @Override
        public IClubTeam getCompetitionTeam(IClubTeam team)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public List<IPlayer> getPlayers(List<Integer> players)
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam)
        {
            service.setCompetitonTeam(competition, oldTeam, newTeam);
        }

        @Override
        public List<IClubTeam> getClubTeams()
        {
            return service.getClubTeams(null);
        }
        
        
    }
    
}
