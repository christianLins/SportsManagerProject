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

        ICountry actual;
        ICountry country = EasyMock.createMock(ICountry.class);
        EasyMock.expect(country.getAlpha2()).andReturn("1").anyTimes();
        EasyMock.expect(country.getAlpha3()).andReturn("2").anyTimes();
        EasyMock.expect(country.getDeutsch()).andReturn("3").anyTimes();
        EasyMock.expect(country.getEspanol()).andReturn("4").anyTimes();
        EasyMock.expect(country.getFrancaise()).andReturn("5").anyTimes();
        EasyMock.expect(country.getItaliano()).andReturn("6").anyTimes();
        EasyMock.expect(country.getName()).andReturn("7").anyTimes();
        EasyMock.expect(country.getPortugues()).andReturn("8").anyTimes();
        EasyMock.expect(country.getTld()).andReturn("9").anyTimes();
        EasyMock.replay(country);

        a.setNationality(country);
        actual = a.getNationality();

        Assert.assertEquals(country.getName(), actual.getName());
        Assert.assertEquals(country.getAlpha3(), actual.getAlpha3());
        Assert.assertEquals(country.getAlpha2(), actual.getAlpha2());
        Assert.assertEquals(country.getTld(), actual.getTld());
        Assert.assertEquals(country.getDeutsch(), actual.getDeutsch());
        Assert.assertEquals(country.getEspanol(), actual.getEspanol());
        Assert.assertEquals(country.getFrancaise(), actual.getFrancaise());
        Assert.assertEquals(country.getItaliano(), actual.getItaliano());
        Assert.assertEquals(country.getPortugues(), actual.getPortugues());
    }

    @Test
    public void addressTest()
    {
        Member a = new Member();

        ICountry country = EasyMock.createMock(ICountry.class);
        EasyMock.expect(country.getAlpha2()).andReturn("1").anyTimes();
        EasyMock.expect(country.getAlpha3()).andReturn("2").anyTimes();
        EasyMock.expect(country.getDeutsch()).andReturn("3").anyTimes();
        EasyMock.expect(country.getEspanol()).andReturn("4").anyTimes();
        EasyMock.expect(country.getFrancaise()).andReturn("5").anyTimes();
        EasyMock.expect(country.getItaliano()).andReturn("6").anyTimes();
        EasyMock.expect(country.getName()).andReturn("7").anyTimes();
        EasyMock.expect(country.getPortugues()).andReturn("8").anyTimes();
        EasyMock.expect(country.getTld()).andReturn("9").anyTimes();
        EasyMock.replay(country);

        IAddress expected = EasyMock.createMock(IAddress.class);
        EasyMock.expect(expected.getCountry()).andReturn(country).anyTimes();
        EasyMock.expect(expected.getPostalCode()).andReturn(1).anyTimes();
        EasyMock.expect(expected.getStreet()).andReturn("Teststreet").anyTimes();
        EasyMock.expect(expected.getStreetNumber()).andReturn(2).anyTimes();
        EasyMock.expect(expected.getVillage()).andReturn("Testvillage").anyTimes();
        EasyMock.replay(expected);

        IAddress actual;

        a.setAddress(expected);
        actual = a.getAddress();

        Assert.assertEquals(expected.getPostalCode(), actual.getPostalCode());
        Assert.assertEquals(expected.getStreet(), actual.getStreet());
        Assert.assertEquals(expected.getStreetNumber(), actual.getStreetNumber());
        Assert.assertEquals(expected.getVillage(), actual.getVillage());

        Assert.assertEquals(country.getName(), actual.getCountry().getName());
        Assert.assertEquals(country.getAlpha3(), actual.getCountry().getAlpha3());
        Assert.assertEquals(country.getAlpha2(), actual.getCountry().getAlpha2());
        Assert.assertEquals(country.getTld(), actual.getCountry().getTld());
        Assert.assertEquals(country.getDeutsch(), actual.getCountry().getDeutsch());
        Assert.assertEquals(country.getEspanol(), actual.getCountry().getEspanol());
        Assert.assertEquals(country.getFrancaise(), actual.getCountry().getFrancaise());
        Assert.assertEquals(country.getItaliano(), actual.getCountry().getItaliano());
        Assert.assertEquals(country.getPortugues(), actual.getCountry().getPortugues());
    }

    @Test
    public void roleListTest()
    {
        Member a = new Member();

        List<IRole> expected = new LinkedList<>();
        expected.add(EasyMock.createMock(IRole.class));
        expected.add(EasyMock.createMock(IRole.class));
        expected.add(EasyMock.createMock(IRole.class));
        EasyMock.replay(expected);

        List<IRole> actual;

        a.setRoleList(expected);
        actual = a.getRoleList();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
