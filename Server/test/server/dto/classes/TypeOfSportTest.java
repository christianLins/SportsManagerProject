/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import contract.dto.ITypeOfSport;

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
    public void copyTest()
    {
        contract.domain.ITypeOfSport t4 = EasyMock.createMock(contract.domain.ITypeOfSport.class);
                EasyMock.expect(t4.getId()).andReturn(2).anyTimes();
        EasyMock.expect(t4.getName()).andReturn("name4").anyTimes();
        EasyMock.expect(t4.getDescription()).andReturn("description4").anyTimes();
        EasyMock.replay(t4);

        contract.dto.ITypeOfSport actual = TypeOfSport.copy(t4);

        Assert.assertEquals(t4.getDescription(), actual.getDescription());
        Assert.assertEquals(t4.getName(), actual.getName());
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
