/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.contract.*;
import sportsclubmanager.dto.classes.Trainer;

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

        List<IClubTeam> expected = new LinkedList<IClubTeam>();
        List<IClubTeam> actual;

        expected.add(EasyMock.createMock(IClubTeam.class));
        expected.add(EasyMock.createMock(IClubTeam.class));
        expected.add(EasyMock.createMock(IClubTeam.class));
        expected.add(EasyMock.createMock(IClubTeam.class));

        a.setClubTeamList(expected);
        actual = a.getClubTeamList();

        Assert.assertEquals(expected, actual);
    }
}
