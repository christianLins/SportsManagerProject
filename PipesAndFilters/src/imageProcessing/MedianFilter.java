/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.*;
import javax.media.jai.operator.MedianFilterDescriptor;
import pipesandfilters.*;

/**

 @author Thomas
 */
class MedianFilter
        extends PassiveFilter<PlanarImage, PlanarImage>
{
    public MedianFilter()
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

        ParameterBlock pb3 = new ParameterBlock();
        pb3.addSource(image);
        pb3.add(MedianFilterDescriptor.MEDIAN_MASK_SQUARE);
        pb3.add(10);
        this.result = JAI.create("MedianFilter", pb3);

        return true;
    }
}
