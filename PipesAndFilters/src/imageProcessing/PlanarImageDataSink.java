/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import com.sun.media.jai.widget.DisplayJAI;
import java.awt.*;
import javax.media.jai.*;
import javax.swing.*;
import pipesandfilters.DataSink;

/**

 @author Thomas
 */
class PlanarImageDataSink
        extends DataSink<PlanarImage>
{
    public PlanarImageDataSink()
    {
    }

    @Override
    public void write(PlanarImage image)
    {
        // Create a frame for display.
        JFrame frame = new JFrame();
        frame.setTitle("DisplayJAI: loetstellen.jpg");

        // Get the JFrame’ ContentPane.
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Create an instance of DisplayJAI.
        DisplayJAI dj = new DisplayJAI(image);

        // Add to the JFrame’ ContentPane an instance of JScrollPane
        // containing the DisplayJAI instance.
        contentPane.add(new JScrollPane(dj), BorderLayout.CENTER);

        // Set the closing operation so the application is finished.   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470, 200); // adjust the frame size.
        frame.setVisible(true); // show the frame.
        JAI.create("filestore", image, "bild.jpg", "JPEG");

    }
}
