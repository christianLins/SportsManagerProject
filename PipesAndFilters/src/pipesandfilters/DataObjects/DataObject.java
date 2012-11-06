/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.DataObjects;

/**

 @author Thomas
 */
public class DataObject
{
    private boolean isEOF = false;

    public void setIsEOF(boolean isEOF)
    {
        this.isEOF = isEOF;
    }

    public boolean getIsEOF()
    {
        return this.isEOF;
    }
}
