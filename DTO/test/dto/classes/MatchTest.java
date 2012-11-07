/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.classes;

import dto.classes.Match;
import java.util.Date;
import org.easymock.EasyMock;
import org.junit.*;
import dto.contract.IMatch;

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
    public void copyTest()
    {
        Date dateFrom = new Date();
        Date dateTo = new Date();

        domain.contract.ITeam hteam = EasyMock.createMock(domain.contract.ITeam.class);
        EasyMock.expect(hteam.getId()).andReturn(1).anyTimes();
        EasyMock.replay(hteam);

        domain.contract.ITeam fteam = EasyMock.createMock(domain.contract.ITeam.class);
        EasyMock.expect(fteam.getId()).andReturn(3).anyTimes();
        EasyMock.replay(fteam);

        domain.contract.IMatchresult result = EasyMock.createMock(domain.contract.IMatchresult.class);
        EasyMock.expect(result.getId()).andReturn(2).anyTimes();
        EasyMock.replay(result);

        domain.contract.ICompetition competition = EasyMock.createMock(domain.contract.ICompetition.class);
        EasyMock.expect(competition.getId()).andReturn(2).anyTimes();
        EasyMock.replay(competition);

        domain.contract.IMatch expected = EasyMock.createMock(domain.contract.IMatch.class);
        EasyMock.expect(expected.getId()).andReturn(2).anyTimes();
        EasyMock.expect(expected.getDateFrom()).andReturn(dateFrom).anyTimes();
        EasyMock.expect(expected.getDateTo()).andReturn(dateTo).anyTimes();
        EasyMock.expect(expected.getForeignteam()).andReturn(fteam).anyTimes();
        EasyMock.expect(expected.getHometeam()).andReturn(hteam).anyTimes();
        EasyMock.expect(expected.getMatchresult()).andReturn(result).anyTimes();
        EasyMock.expect(expected.getCompetition()).andReturn(competition).anyTimes();

        EasyMock.replay(expected);

        Match a = Match.copy(expected);

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

        Integer expected = 1;
        Integer actual;

        a.setCompetition(expected);
        actual = a.getCompetition();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void matchresultTest()
    {
        Match a = new Match();

        Integer expected = 2;
        Integer actual;

        a.setMatchresult(expected);
        actual = a.getMatchresult();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void foreignteamTest()
    {
        Match a = new Match();

        Integer expected = 1;
        Integer actual;

        a.setForeignteam(expected);
        actual = a.getForeignteam();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void hometeamTest()
    {
        Match a = new Match();

        Integer expected = 1;
        Integer actual;

        a.setHometeam(expected);
        actual = a.getHometeam();

        Assert.assertSame(expected, actual);
    }
}
