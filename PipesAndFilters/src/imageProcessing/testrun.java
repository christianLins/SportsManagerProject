/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.io.*;
import java.net.*;
import java.util.logging.*;
import javax.media.jai.PlanarImage;
import pipesandfilters.*;
import pipesandfilters.DataObjects.*;
import pipesandfilters.Filters.*;
import pipesandfilters.Sample.*;

/**

 @author Thomas
 */
public class testrun
{
    /**
     @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Pipes
        Pipe<PlanarImage> firstPipe = new Pipe<>();
        Pipe<PlanarImage> secondPipe = new Pipe<>();
        Pipe<PlanarImage> thridPipe = new Pipe<>();
        Pipe<PlanarImage> fourthPipe = new Pipe<>();
        Pipe<PlanarImage> fifthPipe = new Pipe<>();

        // Filters
        DataSource<PlanarImage> dataSource = new PlanarImageActiveDataSource();
        PassiveFilter<PlanarImage, PlanarImage> roiFilter = new RoiFilter();
        PassiveFilter<PlanarImage, PlanarImage> thresholdFilter = new ThresholdFilter();
        PassiveFilter<PlanarImage, PlanarImage> medianFilter = new MedianFilter();
        PassiveFilter<PlanarImage, PlanarImage> openingFilter = new OpeningFilter();

        DataSink<PlanarImage> dataSink = new PlanarImageDataSink();

        // Binding
        dataSource.getPusher().addSink(firstPipe.getSink());
        firstPipe.getPusher().addSink(roiFilter.getSink());

        roiFilter.getPusher().addSink(secondPipe.getSink());
        secondPipe.getPusher().addSink(thresholdFilter.getSink());

        thresholdFilter.getPusher().addSink(thridPipe.getSink());
        thridPipe.getPusher().addSink(medianFilter.getSink());

        medianFilter.getPusher().addSink(fourthPipe.getSink());
        fourthPipe.getPusher().addSink(openingFilter.getSink());

        openingFilter.getPusher().addSink(fifthPipe.getSink());
        fifthPipe.getPusher().addSink(dataSink.getSink());

        // run
        new Thread((Runnable) dataSource).start();

    }
}
