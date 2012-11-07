/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.client;

import java.rmi.RemoteException;
import rmi.contract.IRmiServiceFactory;
import dto.mapper.contract.IMapper;
import dto.contract.*;

/**
 this class provides the server-side services via rmi

 @author Lins Christian (christian.lins87@gmail.com)
 */
public class RmiServiceClient implements SeviceClient
{
    private IRmiServiceFactory factory;

    public RmiServiceClient(IRmiServiceFactory factory)
            throws CommunicationProblemException
    {
            this.factory = factory;
    }

    public RmiServiceClient()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public IMapper<IAddress> getAddressManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getAddressManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IClubTeam> getClubTeamManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getClubTeamManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ICountry> getCountryManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getCountryManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IDepartment> getDepartmentManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getDepartmentManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IDepartmentHead> getDepartmentHeadManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getDepartmentHeadManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ILeague> getLeagueManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getLeagueManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IMatch> getMatchManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMatchManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IMatchresult> getMatchresultManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMatchresultManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IMember> getMemberManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getMemberManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IPermission> getPermissionManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getPermissionManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<IPlayer> getPlayerManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getPlayerManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ITeam> getTeamManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTeamManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ITrainer> getTrainerManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTrainerManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ITypeOfSport> getTypeOfSportManager()
            throws CommunicationProblemException
    {
        try
        {
            return factory.getTypeOfSportManager();
        }
        catch (RemoteException ex)
        {
            throw new CommunicationProblemException("Problems during fetching service-object from server", ex);
        }
    }

    public IMapper<ICompetition> getCompetitionManager()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
