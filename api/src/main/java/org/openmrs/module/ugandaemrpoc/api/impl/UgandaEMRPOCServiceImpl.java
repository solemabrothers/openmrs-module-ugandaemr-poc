package org.openmrs.module.ugandaemrpoc.api.impl;

import org.openmrs.Location;
import org.openmrs.Provider;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ugandaemrpoc.api.UgandaEMRPOCService;
import org.openmrs.module.ugandaemrpoc.api.db.UgandaEMRPOCDao;
import org.openmrs.module.ugandaemrpoc.model.PatientQueue;

import java.util.Date;
import java.util.List;

public class UgandaEMRPOCServiceImpl extends BaseOpenmrsService implements UgandaEMRPOCService {
	
	UgandaEMRPOCDao dao;
	
	public UgandaEMRPOCServiceImpl() {
	}
	
	public void setDao(UgandaEMRPOCDao dao) {
		this.dao = dao;
	}
	
	public PatientQueue getPatientQueueById(String id) throws APIException {
		return dao.getPatientQueueById(id);
	}
	
	public PatientQueue savePatientQue(PatientQueue patientQueue) throws APIException {
		return dao.savePatientQueue(patientQueue);
	}
	
	public List<PatientQueue> getPatientInQueueList(Provider provider, Date fromDate, Date toDate, Location sessionLocation)
	        throws APIException {
		return dao.getPatientInQueue(provider, fromDate, toDate, sessionLocation);
	}
}
