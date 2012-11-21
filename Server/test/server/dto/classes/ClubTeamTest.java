/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.IClubTeam;
import java.util.*;
import org.junit.*;

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

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setDepartmentList(expected);
        actual = a.getDepartmentList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void trainerListTest()
    {
        ClubTeam a = new ClubTeam();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTrainerList(expected);
        actual = a.getTrainerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void playerListTest()
    {
        ClubTeam a = new ClubTeam();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setPlayerList(expected);
        actual = a.getPlayerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
