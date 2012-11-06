/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import pipesandfilters.DataObjects.*;
import pipesandfilters.PassiveFilter;

/**

 @author Thomas
 */
public class WordFilter
        extends PassiveFilter<Char, Word>
{
    private Char ueberlauf;

    public WordFilter()
    {
        result = new Word("");
    }

    @Override
    public boolean filter(Char value)
    {
        if (value.getIsEOF())
        {
            result.setIsEOF(true);
            return true;
        }

        char c = value.getValue();

        if (Character.isLetter(c))
        {
            result.addChar(c);
            return false;
        }

        ueberlauf = value;
        return true;
    }

    @Override
    public void init()
    {
        result = new Word(ueberlauf);
        ueberlauf = null;
    }
}
