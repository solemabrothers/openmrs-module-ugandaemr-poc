package org.openmrs.module.ugandaemrpoc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.aijar.activator.HtmlFormsInitializer;
import org.openmrs.module.aijar.activator.Initializer;
import org.openmrs.module.dataexchange.DataImporter;

import java.util.ArrayList;
import java.util.List;

public class UgandaEMRPOCActivator extends BaseModuleActivator {
	
	private Log log = LogFactory.getLog(getClass());
	
	public UgandaEMRPOCActivator() {
	}
	
	public void started() {
		for (Initializer initializer : getInitializers()) {
			initializer.started();
		}
		try {
			DataImporter dataImporter = Context.getRegisteredComponent("dataImporter", DataImporter.class);
			dataImporter.importData("metadata/Role_Privilege.xml");
			log.info("Roles and Privileges imported");
		}
		catch (Exception e) {
			
		}
		log.info("Started UgandaEMRPOC");
	}
	
	public void shutdown() {
		log.info("Shutdown UgandaEMRPOC");
	}
	
	private List<Initializer> getInitializers() {
		List<Initializer> l = new ArrayList<Initializer>();
		l.add(new HtmlFormsInitializer(UgandaEMRPOCConstants.MODULE_ID));
		return l;
	}
}
