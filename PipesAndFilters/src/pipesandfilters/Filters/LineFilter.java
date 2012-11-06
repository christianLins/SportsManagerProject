/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import java.util.*;
import pipesandfilters.DataObjects.*;
import pipesandfilters.PassiveFilter;
import pipesandfilters.Sample.Alignment;

/**

 @author Thomas
 */
public class LineFilter
        extends PassiveFilter<Word, Line>
{
    int maxChars = 0;
    Alignment alignment;
    private List<Word> ueberlauf = new LinkedList<>();

    public LineFilter(int maxChars, Alignment alignment)
    {
        this.alignment = alignment;

        init();
        this.maxChars = maxChars;
    }

    @Override
    public boolean filter(Word value)
    {
        if (value.getIsEOF())
        {
            result.setIsEOF(true);
            return true;
        }

        result.add(value);

        if (value.getLength() + countChars() < maxChars)
        {
            return false;
        }

        align();
        return true;
    }

    private int countChars()
    {
        int r = 0;

        for (Word w : this.result.getValue())
        {
            r += w.getLength();
        }

        return r;
    }

    @Override
    public void init()
    {
        result = new Line(new LinkedList<Word>());
        result.addRange(ueberlauf);
        ueberlauf = new LinkedList<>();
    }

    private void align()
    {
        while (maxChars - countChars() > 0)
        {
            if (alignment == Alignment.Left)
            {
                result.add(new Word(" "));
            }
            else if (alignment == Alignment.Right)
            {
                result.addFirst(new Word(" "));
            }
            if (alignment == Alignment.Center)
            {
                if (maxChars - countChars() >= 2)
                {
                    result.add(new Word(" "));
                    result.addFirst(new Word(" "));
                }
                else
                {
                    result.add(new Word(" "));
                }
            }
        }
    }
}
