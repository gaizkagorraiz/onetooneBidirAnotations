package org.gorraiz.hibernate.airlines;

import java.util.List;

import org.gorraiz.hibernate.airlines.dao.AircraftDAO;
import org.gorraiz.hibernate.airlines.models.Aircraft;
import org.gorraiz.hibernate.airlines.models.Pilot;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void showAll(AircraftDAO aircraftDAO) {
		List<Aircraft> aircrafts = aircraftDAO.selectAll();
		System.out.println("--- AIRCRAFT ----- table contents-----------");
		for (Aircraft aircraft : aircrafts) {
			System.out.println("Id: " + aircraft.getId());
			System.out.println(" - Model: " + aircraft.getModel());
			System.out.println(" - Autonomy: " + aircraft.getAutonomy());
			System.out.println(" - Pilot: " + aircraft.getPilot());
		
		}
		System.out.println("Total Aircrft: " + aircrafts.size());
	}
    public static void main( String[] args )    {
    	AircraftDAO aircraftDAO = new AircraftDAO();
    	showAll(aircraftDAO);
     Aircraft airbus = new Aircraft("Airbus",100f);
     Aircraft iberia = new Aircraft("Iberia",52f);
     Pilot mari = new Pilot("Mari",465451);
     Pilot pepe = new Pilot("Pepe",147525);
     
     airbus.setPilot(pepe);
     iberia.setPilot(mari);
     
     	
     	aircraftDAO.insert(iberia);
     	aircraftDAO.insert(airbus);
		
		
    }
}
