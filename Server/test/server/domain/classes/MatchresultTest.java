/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.domain.classes;

import contract.domain.IMatchresult;
import java.util.Random;
import org.junit.*;

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
    public void hibernateContructorTest()
    {
        Integer idMatchresult = new Random().nextInt();

        Matchresult a = new Matchresult(idMatchresult);

        Assert.assertEquals(idMatchresult, a.getId());
    }

    @Test
    public void databaseManagerContructorTest()
    {
        Integer idMatchresult = new Random().nextInt();
        double pointsHometeam = new Random().nextDouble();
        double pointsForeignteam = new Random().nextDouble();

        Matchresult a = new Matchresult(idMatchresult, pointsHometeam, pointsForeignteam);

        Assert.assertEquals(idMatchresult, a.getId());
        Assert.assertEquals(pointsHometeam, a.getPointsHometeam(), 0);
        Assert.assertEquals(pointsForeignteam, a.getPointsForeignteam(), 0);
    }

    @Test
    public void idMatchresultTest()
    {
        Matchresult a = new Matchresult();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
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
