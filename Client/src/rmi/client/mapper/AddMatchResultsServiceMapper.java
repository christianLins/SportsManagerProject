/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.dto.*;
import contract.rmi.services.IAddMatchResultsRmiService;
import contract.useCaseController.IAddMatchResults;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.*;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class AddMatchResultsServiceMapper implements RmiServiceToServiceMapper<IAddMatchResultsRmiService, IAddMatchResults>
{

    @Override
    public IAddMatchResults getService(IAddMatchResultsRmiService rmiService)
    {
        AddMatchResults n = new AddMatchResults();
        n.setService(rmiService);
        return n;        
    }
    
    
    private static class AddMatchResults implements IAddMatchResults{
        
        private IAddMatchResultsRmiService service;
        
        
        public void setService(IAddMatchResultsRmiService service) {
            this.service = service;
        }

        @Override
        public List<ICompetitionDto> getCompetitionList()
        {
            try
            {
                return service.getCompetitionList();
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<ITeamDto> getTeamList(List<Integer> team)
        {
            try
            {
                return service.getTeamList(team);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public List<IMatchDto> getMatchList(List<Integer> match)
        {
            try
            {
                return service.getMatchList(match);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        public void setMatchResult(IMatchDto match, IMatchresultDto matchresult)
        {
            try
            {
                service.setMatchResult(match, matchresult);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(AddMatchResultsServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
