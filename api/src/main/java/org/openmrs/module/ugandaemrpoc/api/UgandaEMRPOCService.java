package org.openmrs.module.ugandaemrpoc.api;

import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.ugandaemrpoc.model.PatientQue;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public abstract interface UgandaEMRPOCService extends OpenmrsService {
	
	@Authorized
	@Transactional(readOnly = true)
	public abstract PatientQue getPatientQueById(String paramString) throws APIException;
	
	@Transactional
	public abstract PatientQue savePatientQue(PatientQue paramPatientQue) throws APIException;
	
	@Transactional
	public abstract List<PatientQue> getPatientInQueList(Provider paramProvider, Date paramDate1, Date paramDate2,
	        Location paramLocation) throws APIException;
}
