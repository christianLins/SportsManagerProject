/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.classes.DepartmentHead;
import sportsclubmanager.domain.contract.*;

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

        List<IDepartment> expected = new LinkedList<IDepartment>();
        expected.add(EasyMock.createMock(IDepartment.class));
        expected.add(EasyMock.createMock(IDepartment.class));
        expected.add(EasyMock.createMock(IDepartment.class));
        expected.add(EasyMock.createMock(IDepartment.class));
        List<IDepartment> actual;

        a.setDepartmentList(expected);
        actual = a.getDepartmentList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
