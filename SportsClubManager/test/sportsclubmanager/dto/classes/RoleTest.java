/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.contract.*;
import sportsclubmanager.dto.classes.Role;

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
    public void hibernateContructorTest()
    {
        Integer idRole = new Random().nextInt();

        Role a = new Role(idRole);

        Assert.assertEquals(idRole, a.getIdRole());
    }

    @Test
    public void permisssionListTest()
    {
        Role a = new Role();

        List<IPermission> expected = new LinkedList<IPermission>();
        expected.add(EasyMock.createMock(IPermission.class));
        expected.add(EasyMock.createMock(IPermission.class));
        expected.add(EasyMock.createMock(IPermission.class));
        expected.add(EasyMock.createMock(IPermission.class));

        List<IPermission> actual;

        a.setPermisssionList(expected);
        actual = a.getPermisssionList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
