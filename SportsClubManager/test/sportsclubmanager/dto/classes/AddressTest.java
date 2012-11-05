/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.dto.classes;

import java.util.Random;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.contract.*;

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

        IAddress actual = Address.copy(expected);

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
        ICountry actual;

        a.setCountry(country);
        actual = a.getCountry();

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
}
