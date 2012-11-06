/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import javax.media.jai.PlanarImage;
import pipesandfilters.PassiveFilter;

/**
 @author Thomas
 */
class RoiFilter
        extends PassiveFilter<PlanarImage, PlanarImage>
{
    @Override
    public void init()
    {
    }

    @Override
    public boolean filter(PlanarImage value)
    {
        Rectangle rectangle = new Rectangle(0, 40, 450, 150);

        PlanarImage image = PlanarImage.wrapRenderedImage((RenderedImage) value.getAsBufferedImage(rectangle, value.getColorModel()));

        this.result = image;

        return true;
    }
}
