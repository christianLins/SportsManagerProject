/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.domain.classes;

import contract.domain.*;
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;

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

        Assert.assertEquals(idRole, a.getId());
    }

    @Test
    public void permisssionListTest()
    {
        Role a = new Role();

        List<IPermission> expected = new LinkedList<>();
        expected.add(EasyMock.createMock(IPermission.class));
        expected.add(EasyMock.createMock(IPermission.class));
        expected.add(EasyMock.createMock(IPermission.class));
        expected.add(EasyMock.createMock(IPermission.class));

        List<IPermission> actual;

        a.setPermissionList(expected);
        actual = a.getPermissionList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
