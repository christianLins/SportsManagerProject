/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.domain.classes;

import contract.domain.ITeam;
import contract.domain.IMatch;
import contract.domain.ICompetition;
import server.domain.classes.Competition;
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;

/**

 @author Thomas
 */
public class CompetitionTest
{
    public CompetitionTest()
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
        Competition a = new Competition();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Competition a = new Competition();

        Assert.assertTrue(a instanceof ICompetition);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idCompetition = new Random().nextInt();

        Competition a = new Competition(idCompetition);

        Assert.assertEquals(idCompetition, a.getId());
    }

    @Test
    public void idCompetitionTest()
    {
        Competition a = new Competition();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dateFromTest()
    {
        Competition a = new Competition();

        Date expected = new Date();
        Date actual;

        a.setDateFrom(expected);
        actual = a.getDateFrom();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dateToTest()
    {
        Competition a = new Competition();

        Date expected = new Date();
        Date actual;

        a.setDateTo(expected);
        actual = a.getDateTo();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void paymentTest()
    {
        Competition a = new Competition();

        Double expected = new Random().nextDouble();
        Double actual;

        a.setPayment(expected);
        actual = a.getPayment();

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void teamListTest()
    {
        Competition a = new Competition();

        List<ITeam> expected = new LinkedList<ITeam>();
        expected.add(EasyMock.createMock(ITeam.class));
        expected.add(EasyMock.createMock(ITeam.class));
        expected.add(EasyMock.createMock(ITeam.class));

        List<ITeam> actual;

        a.setTeamList(expected);
        actual = a.getTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void matchListTest()
    {
        Competition a = new Competition();

        List<IMatch> expected = new LinkedList<IMatch>();
        expected.add(EasyMock.createMock(IMatch.class));
        expected.add(EasyMock.createMock(IMatch.class));
        expected.add(EasyMock.createMock(IMatch.class));

        List<IMatch> actual;

        a.setMatchList(expected);
        actual = a.getMatchList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
