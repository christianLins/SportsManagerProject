/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.contract.*;

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
