package org.openmrs.module.ugandaemrpoc.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ugandaemrpoc.api.UgandaEMRPOCService;
import org.openmrs.module.ugandaemrpoc.api.db.UgandaEMRPOCDao;

public class UgandaEMRPOCServiceImpl extends BaseOpenmrsService implements UgandaEMRPOCService {
	
	UgandaEMRPOCDao dao;
	
	public UgandaEMRPOCServiceImpl() {
	}
	
	public void setDao(UgandaEMRPOCDao dao) {
		this.dao = dao;
	}
	
}
