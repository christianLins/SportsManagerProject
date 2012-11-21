/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import java.util.Random;
import org.junit.*;
import contract.dto.IMatchresult;

/**

 @author Thomas
 */
public class MatchresultTest
{
    public MatchresultTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void emptyConstructorTest()
    {
        Matchresult a = new Matchresult();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Matchresult a = new Matchresult();

        Assert.assertTrue(a instanceof IMatchresult);
    }

    @Test
    public void pointsHometeamTest()
    {
        Matchresult a = new Matchresult();

        double expected = new Random().nextDouble();
        double actual = Integer.MAX_VALUE;

        a.setPointsHometeam(expected);
        actual = a.getPointsHometeam();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void pointsForeignteamTest()
    {
        Matchresult a = new Matchresult();

        double expected = new Random().nextDouble();
        double actual = Integer.MAX_VALUE;

        a.setPointsForeignteam(expected);
        actual = a.getPointsForeignteam();

        Assert.assertEquals(expected, actual, 0);
    }
}
