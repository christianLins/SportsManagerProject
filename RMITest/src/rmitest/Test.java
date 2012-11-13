/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmitest;

import contract.*;
import dto.contract.ICompetition;
import dto.contract.IDepartment;
import dto.contract.ITeam;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ldap.UserData;
import org.w3c.dom.UserDataHandler;
import rmi.client.CommunicationProblemException;
import serviceClientFactories.ServiceClientFactory;
import services.ServiceNotAvailableException;

/**
 *
 * @author Lins Christian (christian.lins87@gmail.com)
 */
public class Test
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        IAddMatchResults addMatchResultsService = null;
        try
        {
            services.ServiceClient client = ServiceClientFactory.getRmiServiceClient("localhost", 1099);
//            IShowCompetition showCompetitionService = client.getShowCompetitionService();
//            List<ICompetition> competitions = showCompetitionService.getCompetitions();
            //            UserData dat = new UserData("cli1929", "mongobongo");
            //            ILogin loginService = client.getLoginService();
            //            loginService.getMemberByUserData(dat);
//            INewCompetition newCompetitionService = client.getNewCompetitionService();
//            List<ITeam> teams = newCompetitionService.getTeams();
            ISearchChangeMember searchChangeMemberService = client.getSearchChangeMemberService();
            List<IDepartment> departments = searchChangeMemberService.getDepartments();
            
        }
        catch (CommunicationProblemException ex)
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ServiceNotAvailableException ex)
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
        }
    }
}
