package org.openmrs.module.ugandaemrpoc.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;

public class PatientQueue extends BaseOpenmrsData {
	
	private Integer patientQueueId;
	
	private Patient patient;
	
	private Provider provider;
	
	private Location locationFrom;
	
	private Location locationTo;
	
	private String status;
	
	public PatientQueue() {
	}
	
	public Integer getId() {
		return patientQueueId;
	}
	
	public void setId(Integer integer) {
		patientQueueId = integer;
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
