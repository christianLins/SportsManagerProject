/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.ICompetition;
import dto.contract.IMember;
import dto.contract.ITeam;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
