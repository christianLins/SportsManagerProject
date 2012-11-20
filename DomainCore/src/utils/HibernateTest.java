package utils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class HibernateTest
{
    private static final String CLASSENDING = ".class";
    private static final String EMPTYSTRING = "";
    private static final String METHODBEGINNING = "get";
    private static final String PACKAGENAME = "domain.classes";

    public Class[] getAllClasses() throws ClassNotFoundException
    {
        ArrayList<Class> classes = new ArrayList<>();
        try
        {
            File dir = new File(Thread.currentThread().getContextClassLoader().getResource(PACKAGENAME.replaceAll("\\.", "/")).getFile());
            if (dir.exists())
            {
                String[] files = dir.list();
                for (String s : files)
                {
                    if (s.endsWith(CLASSENDING))
                    {
                        String classname = s.replace(CLASSENDING, EMPTYSTRING);
                        classes.add(Class.forName(PACKAGENAME + "." + classname));
                    }
                }
            }
            return classes.toArray(new Class[classes.size()]);
        }
        catch (NullPointerException ex)
        {
            throw new ClassNotFoundException(PACKAGENAME, ex);
        }
    }

    public void iterateFields(Object obj) throws ClassNotFoundException
    {
        try
        {
            Method[] methods = obj.getClass().getMethods();
            for (Method m : methods)
            {
                if (m.getName().startsWith(METHODBEGINNING))
                {
                    m.invoke(obj, null);
                }
            }
        }
        catch ( InvocationTargetException | IllegalArgumentException | IllegalAccessException ex)
        {
            Logger.getLogger(HibernateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
