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
public class TypeOfSportTest
{
    public TypeOfSportTest()
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
        TypeOfSport a = new TypeOfSport();
    }

    @Test
    public void implementsInterfaceTest()
    {
        TypeOfSport a = new TypeOfSport();

        Assert.assertTrue(a instanceof ITypeOfSport);
    }

    @Test
    public void nameTest()
    {
        TypeOfSport a = new TypeOfSport();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        TypeOfSport a = new TypeOfSport();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void playerListTest()
    {
        TypeOfSport a = new TypeOfSport();

        List<IPlayer> expected = new LinkedList<>();
        expected.add(EasyMock.createMock(IPlayer.class));
        expected.add(EasyMock.createMock(IPlayer.class));
        expected.add(EasyMock.createMock(IPlayer.class));
        expected.add(EasyMock.createMock(IPlayer.class));

        List<IPlayer> actual;

        a.setPlayerList(expected);
        actual = a.getPlayerList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
