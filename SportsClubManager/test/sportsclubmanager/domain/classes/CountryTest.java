/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain.classes;

import java.util.Random;
import org.junit.*;
import sportsclubmanager.domain.classes.Country;
import sportsclubmanager.domain.contract.ICountry;

/**

 @author Thomas
 */
public class CountryTest
{
    public CountryTest()
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
        Country a = new Country();
    }

    @Test
    public void implementsInterfaceTest()
    {
        Country a = new Country();

        Assert.assertTrue(a instanceof ICountry);
    }

    @Test
    public void hibernateContructorTest()
    {
        Integer idCountry = new Random().nextInt();

        Country a = new Country(idCountry);

        Assert.assertEquals(idCountry, a.getIdCountry());
    }

    @Test
    public void secondHibernateContructorTest()
    {
        Integer idCountry = new Random().nextInt();
        String name = new Random().nextInt() + "";

        Country a = new Country(idCountry, name);

        Assert.assertEquals(idCountry, a.getIdCountry());
        Assert.assertSame(name, a.getName());
    }

    @Test
    public void databaseManagerContructorTest()
    {
        String name = new Random().nextInt() + "";
        String alpha3 = new Random().nextInt() + "";
        String alpha2 = new Random().nextInt() + "";
        String tld = new Random().nextInt() + "";
        String deutsch = new Random().nextInt() + "";
        String espanol = new Random().nextInt() + "";
        String francaise = new Random().nextInt() + "";
        String italiano = new Random().nextInt() + "";
        String portugues = new Random().nextInt() + "";

        Country a = new Country(name, alpha3, alpha2, tld, deutsch, espanol, francaise, italiano, portugues);

        Assert.assertSame(name, a.getName());
        Assert.assertSame(alpha3, a.getAlpha3());
        Assert.assertSame(alpha2, a.getAlpha2());
        Assert.assertSame(tld, a.getTld());
        Assert.assertSame(deutsch, a.getDeutsch());
        Assert.assertSame(espanol, a.getEspanol());
        Assert.assertSame(francaise, a.getFrancaise());
        Assert.assertSame(italiano, a.getItaliano());
        Assert.assertSame(portugues, a.getPortugues());
    }

    @Test
    public void idCountryTest()
    {
        Country a = new Country();

        int expected = new Random().nextInt(10000);
        int actual = Integer.MAX_VALUE;

        a.setIdCountry(expected);
        actual = a.getIdCountry();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setName(expected);
        actual = a.getName();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void alpha3Test()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setAlpha3(expected);
        actual = a.getAlpha3();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void alpha2Test()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setAlpha2(expected);
        actual = a.getAlpha2();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void tldTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setTld(expected);
        actual = a.getTld();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void deutschTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setDeutsch(expected);
        actual = a.getDeutsch();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void espanolTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setEspanol(expected);
        actual = a.getEspanol();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void francaiseTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setFrancaise(expected);
        actual = a.getFrancaise();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void italianoTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setItaliano(expected);
        actual = a.getItaliano();

        Assert.assertSame(expected, actual);
    }

    @Test
    public void portuguesTest()
    {
        Country a = new Country();

        String expected = new Random().nextInt() + "";
        String actual = "";

        a.setPortugues(expected);
        actual = a.getPortugues();

        Assert.assertSame(expected, actual);
    }
}
