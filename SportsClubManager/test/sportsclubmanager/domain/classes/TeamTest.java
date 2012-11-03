/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.classes.Team;
import sportsclubmanager.domain.contract.*;

/**

 @author Thomas
 */
public class TeamTest
{
    public TeamTest()
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
        Team a = new Team();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Team a = new Team();

        Assert.assertTrue(a instanceof ITeam);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idTeam = new Random().nextInt();

        Team a = new Team(idTeam);

        Assert.assertEquals(idTeam, a.getIdTeam());
    }

    @Test
    public void secondHibernateContructorTest()
    {
        Integer idTeam = new Random().nextInt();
        String name = new Random().nextInt() + "";

        Team a = new Team(idTeam, name);

        Assert.assertEquals(idTeam, a.getIdTeam());
        Assert.assertSame(name, a.getName());
    }

    @Test
    public void idTeamTest()
    {
        Team a = new Team();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setIdTeam(expected);
        actual = a.getIdTeam();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameTest()
    {
        Team a = new Team();

        String expected = new Random().nextInt() + "";
        String actual;

        a.setName(expected);
        actual = a.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        Team a = new Team();

        String expected = new Random().nextInt() + "";
        String actual;

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void competitionListTest()
    {
        Team a = new Team();

        List<ICompetition> expected = new LinkedList<ICompetition>();
        expected.add(EasyMock.createMock(ICompetition.class));
        expected.add(EasyMock.createMock(ICompetition.class));
        expected.add(EasyMock.createMock(ICompetition.class));
        List<ICompetition> actual;

        a.setCompetitionList(expected);
        actual = a.getCompetitionList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void clubTeamTest()
    {
        Team a = new Team();

        IClubTeam expected = EasyMock.createMock(IClubTeam.class);
        IClubTeam actual;

        a.setClubTeam(expected);
        actual = a.getClubTeam();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void matchListTest()
    {
        Team a = new Team();

        List<IMatch> expected = new LinkedList<IMatch>();
        expected.add(EasyMock.createMock(IMatch.class));
        expected.add(EasyMock.createMock(IMatch.class));
        expected.add(EasyMock.createMock(IMatch.class));
        List<IMatch> actual;

        a.setMatchList(expected);
        actual = a.getMatchList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void leagueTest()
    {
        Team a = new Team();

        ILeague expected = EasyMock.createMock(ILeague.class);
        ILeague actual;

        a.setLeague(expected);
        actual = a.getLeague();

        Assert.assertSame(expected, actual);
    }
}
