/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.*;
import org.junit.*;
import sportsclubmanager.dto.contract.ITrainer;

/**

 @author Thomas
 */
public class TrainerTest
{
    public TrainerTest()
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
        Trainer a = new Trainer();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Trainer a = new Trainer();

        Assert.assertTrue(a instanceof ITrainer);
    }

    @Test
    public void clubTeamListTest()
    {
        Trainer a = new Trainer();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;


        a.setClubTeamList(expected);
        actual = a.getClubTeamList();

        Assert.assertEquals(expected, actual);
    }
}
