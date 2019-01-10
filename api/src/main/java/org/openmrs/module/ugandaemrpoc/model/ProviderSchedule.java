package org.openmrs.module.ugandaemrpoc.model;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Location;
import org.openmrs.Provider;

public class ProviderSchedule extends BaseOpenmrsData {
	
	private int providerSheduleId;
	
	private Location location;
	
	private Provider provider;
	
	public ProviderSchedule() {
	}
	
	public Integer getId() {
		return null;
	}
	
	public void setId(Integer integer) {
	}
}
