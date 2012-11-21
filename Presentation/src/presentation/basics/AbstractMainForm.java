package presentation.basics;

import contract.dto.*;
import java.util.List;

/**

 @author Lucia
 */
public class AbstractMainForm
        extends AbstractForm
{
    public AbstractMainForm()
    {
        this(null);
    }

    public AbstractMainForm(AbstractForm parent)
    {
        super(parent);
        //initControls(891, 612);
    }

    public AbstractMainForm(AbstractForm parent, int x, int y)
    {
        super(parent);
        //initControls(x, y);
    }

    private void initControls(int x, int y)
    {
        // setSize(x, y);
    }

    public void setTxtFieldSports(List<ITypeOfSport> selected)
    {
        // handle in code
    }

  
    public void setTxtFieldTeams(List<IClubTeam> selected){
        //handle in code
    }
    
    public List<IClubTeam> getClubTeams(ITypeOfSport sport){
      return null;
    }
}
