/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import domain.classes.Department;
import domain.contract.*;

/**

 @author Thomas
 */
public class DepartmentTest
{
    public DepartmentTest()
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
        Department a = new Department();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Department a = new Department();

        Assert.assertTrue(a instanceof IDepartment);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idDepartment = new Random().nextInt();

        Department a = new Department(idDepartment);

        Assert.assertEquals(idDepartment, a.getId());
    }

    @Test
    public void databaseManagerContructorTest()
    {
        int idDepartment = new Random().nextInt();
        String name = new Random().nextInt() + "";

        Department a = new Department(idDepartment, name);

        Assert.assertEquals(name, a.getId());
        Assert.assertSame(name, a.getName());
    }

    @Test
    public void idDepartmentTest()
    {
        Department a = new Department();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameTest()
    {
        Department a = new Department();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void descriptionTest()
    {
        Department a = new Department();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDescription(expected);
        actual = a.getDescription();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void departmentHeadTest()
    {
        Department a = new Department();

        IDepartmentHead expected = EasyMock.createMock(IDepartmentHead.class);
        IDepartmentHead actual;

        a.setDepartmentHead(expected);
        actual = a.getDepartmentHead();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clubTeamListTest()
    {
        Department a = new Department();

        List<IClubTeam> expected = new LinkedList<IClubTeam>();
        expected.add(EasyMock.createMock(IClubTeam.class));
        expected.add(EasyMock.createMock(IClubTeam.class));
        expected.add(EasyMock.createMock(IClubTeam.class));

        List<IClubTeam> actual;

        a.setClubTeamList(expected);
        actual = a.getClubTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void typeOfSportListTest()
    {
        Department a = new Department();

        List<ITypeOfSport> expected = new LinkedList<ITypeOfSport>();
        expected.add(EasyMock.createMock(ITypeOfSport.class));
        expected.add(EasyMock.createMock(ITypeOfSport.class));
        expected.add(EasyMock.createMock(ITypeOfSport.class));

        List<ITypeOfSport> actual;

        a.setTypeOfSportList(expected);
        actual = a.getTypeOfSportList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
