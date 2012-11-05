/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.*;
import org.junit.*;
import sportsclubmanager.dto.contract.IPlayer;

/**

 @author Thomas
 */
public class PlayerTest
{
    public PlayerTest()
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
        Player a = new Player();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Player a = new Player();

        Assert.assertTrue(a instanceof IPlayer);
    }

    @Test
    public void typeOfSportListTest()
    {
        Player a = new Player();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTypeOfSportList(expected);
        actual = a.getTypeOfSportList();

        Assert.assertEquals(expected.size(), actual.size());

        Assert.assertEquals(expected, actual);
    }
}
