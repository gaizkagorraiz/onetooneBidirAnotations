package org.gorraiz.hibernate.airlines.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int licence;
	@OneToOne
	private Aircraft aircraft;
	
	public Pilot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pilot(String name, int licence) {
		super();
		this.name = name;
		this.licence = licence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLicence() {
		return licence;
	}

	public void setLicence(int licence) {
		this.licence = licence;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", name=" + name + ", licence=" + licence + ", aircraft=" + aircraft + "]";
	}
	
	
	
}
