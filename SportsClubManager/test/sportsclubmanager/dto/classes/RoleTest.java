/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import dto.classes.Role;
import java.util.*;
import org.junit.*;
import dto.contract.IRole;

/**

 @author Thomas
 */
public class RoleTest
{
    public RoleTest()
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
        Role a = new Role();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Role a = new Role();

        Assert.assertTrue(a instanceof IRole);
    }

    @Test
    public void permisssionListTest()
    {
        Role a = new Role();

        List<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual;

        a.setPermisssionList(expected);
        actual = a.getPermisssionList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
