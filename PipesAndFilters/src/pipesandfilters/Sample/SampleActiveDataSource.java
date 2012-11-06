/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Sample;

import java.io.*;
import java.net.*;
import java.util.logging.*;
import pipesandfilters.DataObjects.Char;
import pipesandfilters.DataSource;

/**

 @author Thomas
 */
public class SampleActiveDataSource
        extends DataSource<Char>
{
    private InputStream stream;

    SampleActiveDataSource()
            throws FileNotFoundException, UnknownHostException, IOException
    {
        stream = new FileInputStream("C:\\Users\\Thomas\\Documents\\NetBeansProjects\\PipesAndFilters\\src\\pipesandfilters\\Sample\\alice.txt");
    }

    public boolean isEOF(Char value)
    {
        return value.getIsEOF();
    }

    @Override
    public Char getValue()
    {
        try
        {
            if (stream.available() > 0)
            {
                return new Char(stream.read());
            }
            Char c =  new Char('a');
            c.setIsEOF(true);
            return c;
        }
        catch (IOException ex)
        {
            Logger.getLogger(SampleActiveDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
