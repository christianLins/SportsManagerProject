/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import domain.classes.Match;
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import domain.contract.*;

/**

 @author Thomas
 */
public class MatchTest
{
    public MatchTest()
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
        Match a = new Match();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Match a = new Match();

        Assert.assertTrue(a instanceof IMatch);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idMatch = new Random().nextInt();

        Match a = new Match(idMatch);

        Assert.assertEquals(idMatch, a.getId());
    }

    @Test
    public void databaseManagerContructorTest()
    {
        Integer idMatch = new Random().nextInt();
        Date dateFrom = new Date();

        Match a = new Match(idMatch, dateFrom);

        Assert.assertEquals(idMatch, a.getId());
        Assert.assertSame(dateFrom, a.getDateFrom());
    }

    @Test
    public void idMatchTest()
    {
        Match a = new Match();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dateFromTest()
    {
        Match a = new Match();

        Date expected = new Date();
        Date actual;

        a.setDateFrom(expected);
        actual = a.getDateFrom();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dateToTest()
    {
        Match a = new Match();

        Date expected = new Date();
        Date actual;

        a.setDateTo(expected);
        actual = a.getDateTo();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void competitionTest()
    {
        Match a = new Match();

        ICompetition expected = EasyMock.createMock(ICompetition.class);
        ICompetition actual;

        a.setCompetition(expected);
        actual = a.getCompetition();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void matchresultTest()
    {
        Match a = new Match();

        IMatchresult expected = EasyMock.createMock(IMatchresult.class);
        IMatchresult actual;

        a.setMatchresult(expected);
        actual = a.getMatchresult();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void foreignteamTest()
    {
        Match a = new Match();

        ITeam expected = EasyMock.createMock(ITeam.class);
        ITeam actual;

        a.setForeignteam(expected);
        actual = a.getForeignteam();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void hometeamTest()
    {
        Match a = new Match();

        ITeam expected = EasyMock.createMock(ITeam.class);
        ITeam actual;

        a.setHometeam(expected);
        actual = a.getHometeam();

        Assert.assertSame(expected, actual);
    }
}
