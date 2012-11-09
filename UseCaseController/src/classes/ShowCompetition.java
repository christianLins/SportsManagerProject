/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import contract.*;
import dto.contract.IClubTeam;
import dto.contract.ICompetition;
import dto.contract.IMatch;
import dto.contract.IPlayer;
import java.util.List;
/**
 *
 * @author EnjoX
 */
public class ShowCompetition implements IShowCompetition{

    @Override
    public List<ICompetition> getCompetitions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IMatch> getMatchs(List<Integer> matches) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ShowMatchObj> getTeams(List<Integer> matches) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IPlayer getPlayer(IClubTeam team) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
