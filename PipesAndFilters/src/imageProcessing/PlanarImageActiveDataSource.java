/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import javax.media.jai.*;
import pipesandfilters.*;

/**

 @author Thomas
 */
class PlanarImageActiveDataSource
        extends DataSource<PlanarImage>
{
    public PlanarImageActiveDataSource()
    {
    }

    @Override
    public PlanarImage getValue()
    {
        PlanarImage image = JAI.create("fileload", "C:\\Users\\Thomas\\Documents\\NetBeansProjects\\PipesAndFilters\\src\\imageProcessing\\loetstellen.jpg");
        return image;
    }

    @Override
    public boolean isEOF(PlanarImage value)
    {
        return true;
    }
}
