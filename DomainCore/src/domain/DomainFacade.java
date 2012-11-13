/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.classes.*;
import domain.contract.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class DomainFacade
{
    public static DomainFacade instance;
    public static Session session;

    private DomainFacade()
    {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public static DomainFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DomainFacade();
        }
        return instance;
    }

    /**
     * returns all competitions in a time span
     *
     * @param from start of time span
     * @param to end of time span
     * @return all competitions between a timespan given
     */
    public ArrayList<Competition> getCompetitionsByDate(Date from, Date to)
    {
        session.beginTransaction();
        Query query = session.createQuery("from Competition where dateFrom >= :from and dateTo <= :to");
        query.setParameter("from", from);
        query.setParameter("to", to);
        return (ArrayList<Competition>) query.list();
    }

    /**
     * returns a the department of a type of sport
     *
     * @param sport the sport the department belongs to
     * @return the department of the sport
     */
    public Department getDepartmentsBySport(TypeOfSport sport)
    {
//        session.beginTransaction();
//        Query query = session.createQuery("from DepartmenthasTypeOfSport where typeOfSport = :sport");
//        query.setParameter("sport", sport);
//        DepartmenthasTypeOfSport temp = (DepartmenthasTypeOfSport) query.uniqueResult();
//        return temp.getDepartmentidDepartment();
        throw new NotYetImplementedException("new query to be written");
    }

    /**
     * returns all matches of a competition
     *
     * @param competition the competition the matches are in
     * @return all matches of the competition given
     */
    public ArrayList<Match> getMatchesByCompetition(Competition competition)
    {
        session.beginTransaction();
        Query query = session.createQuery("from Match where competition = :competition");
        query.setParameter("competition", competition);
        return (ArrayList<Match>) query.list();
    }

    /**
     * returns a member with the firstname and lastname
     *
     * @param firstname the firstname of the member
     * @param lastname the lastname of the member
     * @return a member with the firstname and lastname given
     */
    public Member getMemberByName(String firstname, String lastname)
    {
        session.beginTransaction();
        Query query = session.createQuery("from Member1 where prename = :firstname and lastname = :lastname");
        return (Member) query.uniqueResult();
    }

    /**
     * returns a object out of the database by its class with a specific name
     *
     * @param <T> the type of class
     * @param clazz the class
     * @param name name of the object
     * @return a object with a name given
     */
    public <T> T getByName(Class<T> clazz, String name)
    {
        Transaction t = session.beginTransaction();
        return (T) session.createCriteria(clazz).add(Restrictions.eq("name", name)).uniqueResult();
    }

    public <T> T getByID(Class<T> clazz, Integer id)
    {
        try{
        session.beginTransaction();
        return (T) session.createCriteria(clazz).add(Restrictions.eq("id", id));}
        catch(HibernateException ex)
        {
            throw ex;
        }
    }
    
    /**
     * Saves a domain object
     * @param <T> the class to be saved
     * @param expected the class instance to be saved
     * @return the id of the saved object
     * @throws CouldNotSaveException 
     */
    public <T extends IDomain> Integer set(T expected)
            throws CouldNotSaveException
    {
        try
        {
            Transaction t = session.beginTransaction();
            session.saveOrUpdate(expected);
            t.commit();

            return expected.getId();
        }
        catch (HibernateException ex)
        {
            throw new CouldNotSaveException(ex);
        }
    }

    /**
     * deletes a line in the database
     * @param <T> the table to be deleted from
     * @param expected the object to be deleted
     * @throws CouldNotDeleteException 
     */
    public <T> void delete(T expected)
            throws CouldNotDeleteException
    {
        try
        {
            Transaction t = session.beginTransaction();
            session.delete(expected);
            t.commit();
        }
        catch (HibernateException ex)
        {
            throw new CouldNotDeleteException(ex);
        }
    }

    /**
     * gets all entries of a table
     * @param <T> the class of the table
     * @param clazz the class instance of the table, i.e. Table.class
     * @return a list of entries
     */
    public <T extends IDomain> List<T> getAll(Class<T> clazz)
    {
        session.beginTransaction();
        return (List<T>) session.createCriteria(clazz).list();
    }
}
