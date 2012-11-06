/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.DataObjects;

import java.util.*;

/**

 @author Thomas
 */
public class Page
        extends DataObject
{
    private List<Line> value;

    public Page()
    {
        value = new LinkedList<Line>();
    }

    public List<Line> getValue()
    {
        return value;
    }

    public void addLine(Line value)
    {
        this.value.add(value);
    }

    public int getLineCount()
    {
        return this.value.size();
    }

    public String toString()
    {
        String result = "";

        for (Line w : value)
        {
            result += w.toString();
            result += "\r\n";
        }

        result += "******************************************************";
        result += "\r\n";

        return result;
    }
}
