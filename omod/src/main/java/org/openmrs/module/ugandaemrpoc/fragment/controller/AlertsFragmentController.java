package org.openmrs.module.ugandaemrpoc.fragment.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.notification.Alert;
import org.springframework.web.bind.annotation.RequestParam;

public class AlertsFragmentController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public AlertsFragmentController() {
	}
	
	public void markAlertAsRead(@RequestParam("alert_message_id") String alertId) {
		Alert alert = Context.getAlertService().getAlert(Integer.valueOf(alertId));
		if (alert != null) {
			alert.setAlertRead(true);
			Context.getAlertService().saveAlert(alert);
		}
	}
}
