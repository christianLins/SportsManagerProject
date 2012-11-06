/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Sample;

import java.io.*;
import java.net.UnknownHostException;
import java.util.logging.*;
import pipesandfilters.DataObjects.*;
import pipesandfilters.Filters.*;
import pipesandfilters.*;

/**

 @author Thomas
 */
public class PipesAndFilters
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            // Pipes
            Pipe<Char> dataSourceToWordFilterPipe = new Pipe<>();
            Pipe<Word> wordToLineFilterPipe = new Pipe<>();
            Pipe<Line> lineToPageFilterPipe = new Pipe<>();
            Pipe<Page> pageToDataSinkPipe = new Pipe<>();
            SyncPipe<Page> syncPipe = new SyncPipe<>();

            // Filters
            DataSource<Char> dataSource = new SampleActiveDataSource();
            PassiveFilter<Char, Word> wordFilter = new WordFilter();
            PassiveFilter<Word, Line> lineFilter = new LineFilter(5, Alignment.Left);
            PassiveFilter<Line, Page> pageFilter = new PageFilter(3);
            DataSink<Page> dataSink = new DataSink<>();

            SampleActiveDataSink<Page> activeDataSink = new SampleActiveDataSink<>();

            boolean push = true;

            if (push)
            { // Push
                // Binding
                dataSource.getPusher().addSink(dataSourceToWordFilterPipe.getSink());
                dataSourceToWordFilterPipe.getPusher().addSink(wordFilter.getSink());

                wordFilter.getPusher().addSink(wordToLineFilterPipe.getSink());
                wordToLineFilterPipe.getPusher().addSink(lineFilter.getSink());

                lineFilter.getPusher().addSink(lineToPageFilterPipe.getSink());
                lineToPageFilterPipe.getPusher().addSink(pageFilter.getSink());

                pageFilter.getPusher().addSink(pageToDataSinkPipe.getSink());
                pageToDataSinkPipe.getPusher().addSink(dataSink.getSink());
                // run
                new Thread((Runnable) dataSource).start();

            }
            else // Push/Pull
            {
                // Binding
                dataSource.getPusher().addSink(dataSourceToWordFilterPipe.getSink());
                dataSourceToWordFilterPipe.getPusher().addSink(wordFilter.getSink());

                wordFilter.getPusher().addSink(wordToLineFilterPipe.getSink());
                wordToLineFilterPipe.getPusher().addSink(lineFilter.getSink());

                lineFilter.getPusher().addSink(lineToPageFilterPipe.getSink());
                lineToPageFilterPipe.getPusher().addSink(pageFilter.getSink());

                pageFilter.getPusher().addSink(syncPipe.getSink());
                activeDataSink.getPuller().setSource(syncPipe.getSource());

                // run
                new Thread((Runnable) dataSource).start();
                new Thread((Runnable) activeDataSink).start();
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PipesAndFilters.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger(PipesAndFilters.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(PipesAndFilters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
