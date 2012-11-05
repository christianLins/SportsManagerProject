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
public class ClubTeamTest
{
    public ClubTeamTest()
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
        ClubTeam a = new ClubTeam();
    }

    @Test
    public void implementsInterfaceTest()
    {
        ClubTeam a = new ClubTeam();

        Assert.assertTrue(a instanceof IClubTeam);
    }

    @Test
    public void implementsSuperclassTest()
    {
        ClubTeam a = new ClubTeam();

        Assert.assertTrue(a instanceof Team);
    }

    @Test
    public void departmentListTest()
    {
        ClubTeam a = new ClubTeam();

        List<IDepartment> expected = new LinkedList<>();
        expected.add(EasyMock.createMock(IDepartment.class));
        expected.add(EasyMock.createMock(IDepartment.class));
        expected.add(EasyMock.createMock(IDepartment.class));
        List<IDepartment> actual;

        a.setDepartmentList(expected);
        actual = a.getDepartmentList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void trainerListTest()
    {
        ClubTeam a = new ClubTeam();

        List<ITrainer> expected = new LinkedList<ITrainer>();
        expected.add(EasyMock.createMock(ITrainer.class));
        expected.add(EasyMock.createMock(ITrainer.class));
        expected.add(EasyMock.createMock(ITrainer.class));
        List<ITrainer> actual;

        a.setTrainerList(expected);
        actual = a.getTrainerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void playerListTest()
    {
        ClubTeam a = new ClubTeam();

        List<IPlayer> expected = new LinkedList<IPlayer>();
        expected.add(EasyMock.createMock(IPlayer.class));
        expected.add(EasyMock.createMock(IPlayer.class));
        expected.add(EasyMock.createMock(IPlayer.class));
        List<IPlayer> actual;

        a.setPlayerList(expected);
        actual = a.getPlayerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
