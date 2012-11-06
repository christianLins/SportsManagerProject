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
public class PageFilter
        extends PassiveFilter<Line, Page>
{
    int lineCount = 30;

    public PageFilter(int lineCount)
    {
        result = new Page();

        this.lineCount = lineCount;
    }

    @Override
    public boolean filter(Line value)
    {
        result.addLine(value);

        if (value.getIsEOF())
        {
            return true;
        }

        if (result.getLineCount() >= lineCount)
        {
            return true;
        }

        return false;
    }

    @Override
    public void init()
    {
        result = new Page();
    }
}
