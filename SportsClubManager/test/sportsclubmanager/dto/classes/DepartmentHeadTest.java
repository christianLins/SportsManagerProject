/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.*;
import org.junit.*;
import sportsclubmanager.dto.contract.IDepartmentHead;

/**

 @author Thomas
 */
public class DepartmentHeadTest
{
    public DepartmentHeadTest()
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
        DepartmentHead a = new DepartmentHead();
    }

    @Test
    public void implementsInterfaceTest()
    {
        DepartmentHead a = new DepartmentHead();

        Assert.assertTrue(a instanceof IDepartmentHead);
    }

    @Test
    public void departmentListTest()
    {
        DepartmentHead a = new DepartmentHead();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setDepartmentList(expected);
        actual = a.getDepartmentList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
