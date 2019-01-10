package org.openmrs.module.ugandaemrpoc.api.impl;

import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ugandaemrpoc.api.UgandaEMRPOCService;
import org.openmrs.module.ugandaemrpoc.api.db.UgandaEMRPOCDao;
import org.openmrs.module.ugandaemrpoc.model.PatientQue;

import java.util.Date;
import java.util.List;

public class UgandaEMRPOCServiceImpl extends BaseOpenmrsService implements UgandaEMRPOCService {
	
	UgandaEMRPOCDao dao;
	
	public UgandaEMRPOCServiceImpl() {
	}
	
	public void setDao(UgandaEMRPOCDao dao) {
		this.dao = dao;
	}
	
	public PatientQue getPatientQueById(String id) throws APIException {
		return dao.getPatientQueById(id);
	}
	
	public PatientQue savePatientQue(PatientQue patientQue) throws APIException {
		return dao.savePatientQue(patientQue);
	}
	
	public List<PatientQue> getPatientInQueList(Provider provider, Date fromDate, Date toDate, Location sessionLocation)
	        throws APIException {
		return dao.getPatientInQue(provider, fromDate, toDate, sessionLocation);
	}
}
