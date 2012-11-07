/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import dto.classes.Department;
import java.util.*;
import org.junit.*;
import dto.contract.IDepartment;

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

        Integer expected = 2;
        Integer actual;

        a.setDepartmentHead(expected);
        actual = a.getDepartmentHead();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clubTeamListTest()
    {
        Department a = new Department();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setClubTeamList(expected);
        actual = a.getClubTeamList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void typeOfSportListTest()
    {
        Department a = new Department();
        
        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setTypeOfSportList(expected);
        actual = a.getTypeOfSportList();

        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < actual.size(); i++)
        {
            Assert.assertEquals(expected, actual);
        }
    }
}
