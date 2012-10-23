/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import sportsclubmanager.domain.classes.Competition;
import sportsclubmanager.domain.classes.Country;
import sportsclubmanager.utils.HibernateUtil;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
public class DomainFacade
{
    public ArrayList<Country> getAllCountries()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Country> allCountries = (ArrayList<Country>) session.createCriteria(Country.class).list();
        return allCountries;
    }
    
    public Country getCountryByName(String name)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Country country = (Country) session.createCriteria(Country.class).add(Restrictions.eq("name", name)).uniqueResult();
        return country;
    }
    
    public ArrayList<Competition> getAllCompetitions()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Competition> allCompetitions = (ArrayList<Competition>) session.createCriteria(Competition.class).list();
        return allCompetitions;
    }
    
    public ArrayList<Competition> getCompetitionsByDate(Date from, Date to)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Competition where dateFrom >= :from and dateTo <= :to");
        query.setParameter("from", from);
        query.setParameter("to", to);
        return (ArrayList<Competition>) query.list();
    }
    
    //You guys can do the rest :-D
}
