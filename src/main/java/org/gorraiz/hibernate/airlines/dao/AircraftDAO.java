package org.gorraiz.hibernate.airlines.dao;

import java.util.List;

import org.gorraiz.hibernate.airlines.HibernateSession;
import org.gorraiz.hibernate.airlines.models.Aircraft;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class AircraftDAO implements AircraftDAOInterface{
	/* 
	 * selects one aircraft by Id
	 * @param id
	 * @return Aircraft
	 */
	public Aircraft selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Aircraft aircraft = (Aircraft) session.get(Aircraft.class, id);
	    
	    session.close();
	    return aircraft;
	}

	/*
	 * retrieves all aircrafts from db
	 * @return List of aircrafts
	 */
	public List<Aircraft> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Aircraft> aircrafts = session.createQuery("from Aircraft").list();
	    
	    session.close();
	    return aircrafts;
	}
	

	/*
	 * inserts a new Aircraft in database
	 * Aircraft must come with the id set 
	 * @param new aircraft
	 */
	public void insert(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(aircraft);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates Aircraft
	 * @param aircraft to update
	 */
	public void update(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(aircraft); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}
	

	/*
	 * delete given Aircraft
	 * @param aircraft to delete
	 */
	public void delete(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(aircraft);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}

