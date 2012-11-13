/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.IChangeCompetitionTeam;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import dto.contract.IPlayer;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private static class ChangeCompetitionTeam implements IChangeCompetitionTeam {
        
        private IChangeCompetitionTeamRmiService service;
        
        
        public void setService(IChangeCompetitionTeamRmiService service) {
            this.service = service;
        }

        @Override
        public List<ICompetition> getCompetition()
        {
            try
            {
                return service.getCompetition();
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IClubTeam> getClubTeams(List<Integer> Teams)
        {
            try
            {
                return service.getClubTeams(Teams);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public IClubTeam getCompetitionTeam(IClubTeam team)
        {
            try
            {
                return service.getCompetitionTeam(team);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IPlayer> getPlayers(List<Integer> players)
        {
            try
            {
                return service.getPlayers(players);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public void setCompetitonTeam(ICompetition competition, IClubTeam oldTeam, IClubTeam newTeam)
        {
            try
            {
                service.setCompetitonTeam(competition, oldTeam, newTeam);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public List<IClubTeam> getClubTeams()
        {
            try
            {
                return service.getClubTeams(null);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(ChangeCompetitionTeamServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        
    }
    
}
