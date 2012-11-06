/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.awt.image.renderable.ParameterBlock;
import javax.media.jai.*;
import pipesandfilters.PassiveFilter;

/**

 @author Thomas
 */
class OpeningFilter
        extends PassiveFilter<PlanarImage, PlanarImage>
{
    public OpeningFilter()
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

        this.result = image;

        return true;
    }
}
