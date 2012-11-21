package server.domain.database.test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import contract.domain.*;
import java.util.*;
import java.util.logging.*;
import org.easymock.EasyMock;
import org.junit.*;
import server.database.DatabaseManager;
import server.domain.DomainFacade;

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

            DomainFacade.getInstance().set(expected);

            List<ITypeOfSport> actuals = DomainFacade.getInstance().getAll(ITypeOfSport.class);
            ITypeOfSport actual = actuals.get(0);

            Assert.assertEquals(1, actuals.size());
            Assert.assertEquals(expected.getName(), actual.getName());
            Assert.assertEquals(expected.getDescription(), actual.getDescription());
        }
        catch (CouldNotFetchException ex)
        {
            Logger.getLogger(TypeOfSportTest.class.getName()).log(Level.SEVERE, null, ex);
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

            DomainFacade.getInstance().set(expected);
            DomainFacade.getInstance().delete(expected);

            List<ITypeOfSport> actuals = DomainFacade.getInstance().getAll(ITypeOfSport.class);

            Assert.assertEquals(0, actuals.size());
        }
        catch (CouldNotFetchException ex)
        {
            Logger.getLogger(TypeOfSportTest.class.getName()).log(Level.SEVERE, null, ex);
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
        try
        {
            List<ITypeOfSport> expecteds = new LinkedList<>();

            for (int i = 0; i < 2; i++)
            {
                try
                {
                    ITypeOfSport expected = EasyMock.createMock(ITypeOfSport.class);

                    EasyMock.expect(expected.getName()).andReturn("Testname" + i);
                    EasyMock.expect(expected.getDescription()).andReturn("Testdescription" + i);

                    expecteds.add(expected);
                    DomainFacade.getInstance().set(expected);
                }
                catch (CouldNotSaveException ex)
                {
                    Assert.fail("A exception is thrown");
                }
            }

            List<ITypeOfSport> actuals = DomainFacade.getInstance().getAll(ITypeOfSport.class);

            Assert.assertEquals(expecteds.size(), actuals.size());

            for (int i = 0; i < expecteds.size(); i++)
            {
                ITypeOfSport expected = expecteds.get(i);
                ITypeOfSport actual = actuals.get(i);
                Assert.assertEquals(expected.getName(), actual.getName());
                Assert.assertEquals(expected.getDescription(), actual.getDescription());
            }
        }
        catch (CouldNotFetchException ex)
        {
            Logger.getLogger(TypeOfSportTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
