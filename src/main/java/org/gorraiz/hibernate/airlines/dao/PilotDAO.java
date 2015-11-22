package org.gorraiz.hibernate.airlines.dao;

import java.util.List;

import org.gorraiz.hibernate.airlines.HibernateSession;
import org.gorraiz.hibernate.airlines.models.Pilot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PilotDAO implements PilotDAOInterface {
	/* 
	 * selects one President by Id
	 * @param id
	 * @return President
	 */
	public Pilot selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Pilot piloto = (Pilot) session.get(Pilot.class, id);
	    
	    session.close();
	    return piloto;
	}

	/*
	 * retrieves all Pilots from db
	 * @return List of Pilotos
	 */
	public List<Pilot> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Pilot> pilotos = session.createQuery("from Pilot").list();
	    
	    session.close();
	    return pilotos;
	}
	

	/*
	 * inserts a new Pilot in database
	 * retrieves generated id and sets to Pilot instance
	 * @param new Pilot
	 */
	public void insert(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(pilot);
	         
	    session.getTransaction().commit();
	    session.close();

	}
	

	/*
	 * updates Pilot
	 * @param Pilot to update
	 */
	public void update(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(pilot);
		 
		    session.getTransaction().commit();
		    session.close();
	}
	

	/*
	 * delete given President
	 * @param President to delete
	 */
	public void delete(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(pilot);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
