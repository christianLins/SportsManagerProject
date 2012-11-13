/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client.mapper;

import contract.INewCompetition;
import dto.contract.ICompetition;
import dto.contract.IMember;
import dto.contract.ITeam;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.contract.services.INewCompetitionRmiService;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class NewCompetitionServiceMapper implements RmiServiceToServiceMapper<INewCompetitionRmiService, INewCompetition>
{

    @Override
    public INewCompetition getService(INewCompetitionRmiService rmiService)
    {
        NewCompetition n = new NewCompetition();
        n.setService(rmiService);
        return n;  
    }
    
    class NewCompetition implements INewCompetition {
        
        private INewCompetitionRmiService service;
        
        
        public void setService(INewCompetitionRmiService service) {
            this.service = service;
        }

        @Override
        public void setCompetition(ICompetition competition, IMember member)
        {
            try
            {
                service.setCompetition(competition, member);
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public List<ITeam> getTeams()
        {
            try
            {
                return service.getTeams();
            }
            catch (RemoteException ex)
            {
                Logger.getLogger(NewCompetitionServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        
    }
    
}
