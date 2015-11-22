package org.gorraiz.hibernate.airlines.models;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



public class Aircraft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private Float autonomy;
	@OneToOne(mappedBy="pilot", cascade = CascadeType.ALL)
	private Pilot pilot;
	
	public Aircraft() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aircraft(String model, Float autonomy) {
		super();
		this.model = model;
		this.autonomy = autonomy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Float getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(Float autonomy) {
		this.autonomy = autonomy;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	@Override
	public String toString() {
		return "Aircraft [id=" + id + ", model=" + model + ", autonomy=" + autonomy + ", pilot=" + pilot + "]";
	}
	
	
	
}
