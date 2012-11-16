/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package corbaserver;

import corbaContract.generated.*;
import org.omg.CORBA.ORB;

/**

 @author Thomas
 */
public class MatchresultDataproviderServant
        extends MatchresultDataproviderPOA
{
    private ORB orb;

    public void setORB(ORB orb_val)
    {
        orb = orb_val;
    }

    @Override
    public MatchresultListCorba getMatchresults(String typeOfSport, String league, String competitiondate)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isMatchresultFinal(MatchresultCorba mtachresult)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void shutdown()
    {
        orb.shutdown(false);
    }
}
