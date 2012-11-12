/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.ICompetition;
import dto.contract.IMember;
import dto.contract.ITeam;
import dto.mapper.DtoFactory;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author EnjoX
 */
public class NewCompetition implements INewCompetition{
    private static INewCompetition INSTANCE;
    
    public static INewCompetition getInstance() {
        if(INSTANCE == null) INSTANCE = new NewCompetition();
        return INSTANCE;
    }

    @Override
    public void setCompetition(ICompetition competition, IMember member) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ITeam> getTeams() {
        try {
            return DtoFactory.getTeamManager().getAll();
        } catch (RemoteException ex) {
            Logger.getLogger(NewCompetition.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
