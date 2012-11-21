/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dto.classes;

import contract.dto.IAddress;
import java.util.Random;
import org.easymock.EasyMock;
import org.junit.*;

/**

 @author Thomas
 */
public class AddressTest
{
    public AddressTest()
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
        Address a = new Address();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Address a = new Address();

        Assert.assertTrue(a instanceof IAddress);
    }

    @Test
    public void interfaceConstructorTest()
    {
        contract.domain.ICountry country = EasyMock.createMock(contract.domain.ICountry.class);
        EasyMock.expect(country.getId()).andReturn(1).anyTimes();
        EasyMock.replay(country);

        contract.domain.IAddress expected = EasyMock.createMock(contract.domain.IAddress.class);
        EasyMock.expect(expected.getId()).andReturn(2).anyTimes();
        EasyMock.expect(expected.getCountry()).andReturn(country).anyTimes();
        EasyMock.expect(expected.getPostalCode()).andReturn(1).anyTimes();
        EasyMock.expect(expected.getStreet()).andReturn("Teststreet").anyTimes();
        EasyMock.expect(expected.getStreetNumber()).andReturn(2).anyTimes();
        EasyMock.expect(expected.getVillage()).andReturn("Testvillage").anyTimes();
        EasyMock.replay(expected);

        Address actual = Address.copy(expected);

        Assert.assertEquals(expected.getPostalCode(), actual.getPostalCode());
        Assert.assertEquals(expected.getStreet(), actual.getStreet());
        Assert.assertEquals(expected.getStreetNumber(), actual.getStreetNumber());
        Assert.assertEquals(expected.getVillage(), actual.getVillage());

        Assert.assertEquals(country.getId(), (Integer) actual.getCountry());
    }

    @Test
    public void streetTest()
    {
        Address a = new Address();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setStreet(expected);
        actual = a.getStreet();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void streetNumberTest()
    {
        Address a = new Address();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setStreetNumber(expected);
        actual = a.getStreetNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void villageTest()
    {
        Address a = new Address();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setVillage(expected);
        actual = a.getVillage();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void postalCodeTest()
    {
        Address a = new Address();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setPostalCode(expected);
        actual = a.getPostalCode();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countryTest()
    {
        Address a = new Address();

        Integer country = 1;
        Integer actual;

        a.setCountry(country);
        actual = a.getCountry();

        Assert.assertEquals(country, actual);
    }
}
