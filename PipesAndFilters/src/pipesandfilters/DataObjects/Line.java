/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.DataObjects;

import java.util.List;

/**

 @author Thomas
 */
public class Line
        extends DataObject
{
    public static int lineNumber = 0;
    public int currentLineNumber = 0;
    private List<Word> value;

    public Line(List<Word> line)
    {
        currentLineNumber = ++lineNumber;
        value = line;
    }

    public List<Word> getValue()
    {
        return value;
    }

    public String toString()
    {
        String result = "";

        for (Word w : value)
        {
            result += w.toString();
        }

        return result;
    }

    public void add(Word value)
    {
        this.value.add(value);
    }

    public void addRange(List<Word> ueberlauf)
    {
        for (Word w : ueberlauf)
        {
            this.add(w);
        }
    }

    public void addFirst(Word word)
    {
        value.add(0, word);
    }
}
