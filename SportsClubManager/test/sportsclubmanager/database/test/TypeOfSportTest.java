package sportsclubmanager.database.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import org.easymock.EasyMock;
import org.junit.*;
import sportsclubmanager.domain.*;
import sportsclubmanager.domain.contract.ITypeOfSport;

/**

 @author Thomas
 */
public class TypeOfSportTest
{
    @Before
    public void setUp()
    {
        DatabaseManager.clearDatabase();
    }

    @Test
    public void GetAndSetTypeOfSport()
    {
        try
        {
            ITypeOfSport expected = EasyMock.createMock(ITypeOfSport.class);

            EasyMock.expect(expected.getName()).andReturn("Testname");
            EasyMock.expect(expected.getDescription()).andReturn("Testdescription");

            DomainFacade.set(expected);

            List<ITypeOfSport> actuals = DomainFacade.getAll(ITypeOfSport.class);
            ITypeOfSport actual = actuals.get(0);

            Assert.assertEquals(1, actuals.size());
            Assert.assertEquals(expected.getName(), actual.getName());
            Assert.assertEquals(expected.getDescription(), actual.getDescription());
        }
        catch (CouldNotSaveException ex)
        {
            Assert.fail("A exception is thrown");
        }
    }

    @Test
    public void GetAndDeleteTypeOfSport()
    {
        try
        {
            ITypeOfSport expected = EasyMock.createMock(ITypeOfSport.class);

            EasyMock.expect(expected.getName()).andReturn("Testname");
            EasyMock.expect(expected.getDescription()).andReturn("Testdescription");

            DomainFacade.set(expected);
            DomainFacade.delete(expected);

            List<ITypeOfSport> actuals = DomainFacade.getAll(ITypeOfSport.class);

            Assert.assertEquals(0, actuals.size());
        }
        catch (CouldNotSaveException ex)
        {
            Assert.fail("A exception is thrown");
        }
        catch (CouldNotDeleteException ex)
        {
            Assert.fail("A exception is thrown");
        }
    }

    @Test
    public void GetAndSetMultipleTypeOfSport()
    {
        List<ITypeOfSport> expecteds = new LinkedList<ITypeOfSport>();

        for (int i = 0; i < 2; i++)
        {
            try
            {
                ITypeOfSport expected = EasyMock.createMock(ITypeOfSport.class);

                EasyMock.expect(expected.getName()).andReturn("Testname" + i);
                EasyMock.expect(expected.getDescription()).andReturn("Testdescription" + i);

                expecteds.add(expected);
                DomainFacade.set(expected);
            }
            catch (CouldNotSaveException ex)
            {
                Assert.fail("A exception is thrown");
            }
        }

        List<ITypeOfSport> actuals = DomainFacade.getAll(ITypeOfSport.class);

        Assert.assertEquals(expecteds.size(), actuals.size());

        for (int i = 0; i < expecteds.size(); i++)
        {
            ITypeOfSport expected = expecteds.get(i);
            ITypeOfSport actual = actuals.get(i);
            Assert.assertEquals(expected.getName(), actual.getName());
            Assert.assertEquals(expected.getDescription(), actual.getDescription());
        }
    }
}
