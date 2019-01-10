package org.openmrs.module.ugandaemrpoc.api.db;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.module.ugandaemrpoc.model.PatientQue;

import java.util.Date;
import java.util.List;

public abstract interface UgandaEMRPOCDao {
	
	public abstract PatientQue getPatientQueById(String paramString);
	
	public abstract List<PatientQue> getPatientQueByPatient(Patient paramPatient);
	
	public abstract PatientQue savePatientQue(PatientQue paramPatientQue);
	
	public abstract List<PatientQue> getPatientInQue(Provider paramProvider, Date paramDate1, Date paramDate2,
	        Location paramLocation);
}
