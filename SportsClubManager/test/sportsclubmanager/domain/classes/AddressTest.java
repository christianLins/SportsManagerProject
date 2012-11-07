/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import domain.classes.Address;
import java.util.Random;
import org.easymock.EasyMock;
import org.junit.*;
import domain.contract.*;

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
    public void hibernateContructorTest()
    {
        Integer idAddress = new Random().nextInt();
        String street = new Random().nextInt() + "";
        int streetNumber = new Random().nextInt();
        String village = new Random().nextInt() + "";
        int postalCode = new Random().nextInt();

        Address a = new Address(idAddress, street, streetNumber, village, postalCode);

        Assert.assertEquals(idAddress, a.getId());
        Assert.assertSame(street, a.getStreet());
        Assert.assertEquals(streetNumber, a.getStreetNumber());
        Assert.assertSame(village, a.getVillage());
        Assert.assertEquals(postalCode, a.getPostalCode());
    }

    @Test
    public void idTest()
    {
        Address a = new Address();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setId(expected);
        actual = a.getId();

        Assert.assertEquals(expected, actual);
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

        ICountry expected = EasyMock.createMock(ICountry.class);
        ICountry actual;

        a.setCountry(expected);
        actual = a.getCountry();

        Assert.assertSame(expected, actual);
    }
}
