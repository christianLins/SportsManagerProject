/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.awt.*;
import javax.media.jai.*;

/**

 @author Thomas
 */
class RoiPlanarImage
{
    private final PlanarImage image;
    private final Rectangle rectangle;
    private final PlanarImage manipulatedImage;

    public RoiPlanarImage(PlanarImage image, PlanarImage manipulatedImage, Rectangle rectangle)
    {
        this.image = image;
        this.manipulatedImage = manipulatedImage;
        this.rectangle = rectangle;
    }

    /**
     @return the image
     */
    public PlanarImage getImage()
    {
        return image;
    }

    /**
     @return the rectangle
     */
    public Rectangle getRectangle()
    {
        return rectangle;
    }

    PlanarImage getManipulatedImage()
    {
        return manipulatedImage;
    }
}
