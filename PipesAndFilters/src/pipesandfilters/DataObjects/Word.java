/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.DataObjects;

/**

 @author Thomas
 */
public class Word
        extends DataObject
{
    private String value;

    public Word(String word)
    {
        value = word;
    }

    public Word(Char c)
    {
        if (c == null)
        {
            value = "";
        }
        else
        {
                    value = c.getValue() + "";
        }
    }

    public String getValue()
    {
        return value;
    }

    public void addChar(char c)
    {
        value += c;
    }

    public int getLength()
    {
        return value.length();
    }

    public String toString()
    {
        return value;
    }
}
