package org.openmrs.module.ugandaemrpoc.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;

public class PatientQue extends BaseOpenmrsData {
	
	private Integer patientQueId;
	
	private Patient patient;
	
	private Provider provider;
	
	private Location locationFrom;
	
	private Location locationTo;
	
	private String status;
	
	public PatientQue() {
	}
	
	public Integer getId() {
		return patientQueId;
	}
	
	public void setId(Integer integer) {
		patientQueId = integer;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Provider getProvider() {
		return provider;
	}
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public Location getLocationFrom() {
		return locationFrom;
	}
	
	public void setLocationFrom(Location locationFrom) {
		this.locationFrom = locationFrom;
	}
	
	public Location getLocationTo() {
		return locationTo;
	}
	
	public void setLocationTo(Location locationTo) {
		this.locationTo = locationTo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
