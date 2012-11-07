/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import domain.classes.Member;
import domain.contract.*;

/**

 @author Thomas
 */
public class MemberTest
{
    public MemberTest()
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
        Member a = new Member();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Member a = new Member();

        Assert.assertTrue(a instanceof IMember);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idMember = new Random().nextInt();

        Member a = new Member(idMember);

        Assert.assertEquals(idMember, a.getIdMember());
    }

    @Test
    public void idMemberTest()
    {
        Member a = new Member();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setIdMember(expected);
        actual = a.getIdMember();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void prenameTest()
    {
        Member a = new Member();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setPrename(expected);
        actual = a.getPrename();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void lastnameTest()
    {
        Member a = new Member();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setLastname(expected);
        actual = a.getLastname();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void dateOfBirthTest()
    {
        Member a = new Member();

        Date expected = new Date();
        Date actual;

        a.setDateOfBirth(expected);
        actual = a.getDateOfBirth();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void mmemberFromTest()
    {
        Member a = new Member();

        Date expected = new Date();
        Date actual;

        a.setMemberFrom(expected);
        actual = a.getMemberFrom();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void mmemberToTest()
    {
        Member a = new Member();

        Date expected = new Date();
        Date actual;

        a.setMemberTo(expected);
        actual = a.getMemberTo();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void telephonenumberTest()
    {
        Member a = new Member();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setTelephonenumber(expected);
        actual = a.getTelephonenumber();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void emailAddressTest()
    {
        Member a = new Member();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setEmailAddress(expected);
        actual = a.getEmailAddress();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void genderTest()
    {
        Member a = new Member();

        boolean expected = true;
        boolean actual = false;

        a.setGender(expected);
        actual = a.getGender();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void nationalityTest()
    {
        Member a = new Member();

        ICountry expected = EasyMock.createMock(ICountry.class);
        ICountry actual;

        a.setNationality(expected);
        actual = a.getNationality();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void addressTest()
    {
        Member a = new Member();

        IAddress expected = EasyMock.createMock(IAddress.class);
        IAddress actual;

        a.setAddress(expected);
        actual = a.getAddress();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void roleListTest()
    {
        Member a = new Member();

        List<IRole> expected = new LinkedList<IRole>();
        expected.add(EasyMock.createMock(IRole.class));
        expected.add(EasyMock.createMock(IRole.class));
        expected.add(EasyMock.createMock(IRole.class));

        List<IRole> actual;

        a.setRoleList(expected);
        actual = a.getRoleList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
