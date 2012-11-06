/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.*;
import pipesandfilters.*;

/**

 @author Thomas
 */
class ThresholdFilter
        extends PassiveFilter<PlanarImage, PlanarImage>
{
    public ThresholdFilter()
    {
    }

    @Override
    public void init()
    {
    }

    @Override
    public boolean filter(PlanarImage value)
    {
        PlanarImage image = PlanarImage.wrapRenderedImage(value.getAsBufferedImage());

        int bands = image.getNumBands();

        double[] low, high, map;

        low = new double[bands];
        high = new double[bands];
        map = new double[bands];
        for (int i = 0; i < bands; i++)
        {
            low[i] = 0;
            high[i] = 45;
            map[i] = 255;
        }

        ParameterBlock pb = new ParameterBlock();
        pb.addSource(image);
        pb.add(low);
        pb.add(high);
        pb.add(map);
        this.result = JAI.create("threshold", pb);

        return true;
    }
}
