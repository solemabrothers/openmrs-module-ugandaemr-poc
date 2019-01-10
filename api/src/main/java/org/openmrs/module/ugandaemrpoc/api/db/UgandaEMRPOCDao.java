package org.openmrs.module.ugandaemrpoc.api.db;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.module.ugandaemrpoc.model.PatientQueue;

import java.util.Date;
import java.util.List;

public abstract interface UgandaEMRPOCDao {
	
	public abstract PatientQueue getPatientQueueById(String paramString);
	
	public abstract List<PatientQueue> getPatientQueueByPatient(Patient paramPatient);
	
	public abstract PatientQueue savePatientQueue(PatientQueue paramPatientQueue);
	
	public abstract List<PatientQueue> getPatientInQueue(Provider paramProvider, Date paramDate1, Date paramDate2,
	        Location paramLocation);
}
