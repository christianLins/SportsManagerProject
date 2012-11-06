/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.DataObjects;

/**

 @author Thomas
 */
public class Char
        extends DataObject
{
    private int value;

    public Char(int c)
    {
        value = c;
    }

    public Char(char c)
    {
        value = c;
    }

    public char getValue()
    {
        return (char) value;
    }
}
