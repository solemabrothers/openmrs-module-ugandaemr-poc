package org.openmrs.module.ugandaemrpoc.page.controller;

import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.module.ugandaemrpoc.api.UgandaEMRPOCService;
import org.openmrs.module.ugandaemrpoc.model.PatientQueue;
import org.openmrs.notification.Alert;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClinicianDashboardPageController {
	
	protected final org.apache.commons.logging.Log log = LogFactory.getLog(getClass());
	
	public ClinicianDashboardPageController() {
	}
	
	public void controller(@SpringBean PageModel pageModel,
	        @RequestParam(value = "app", required = false) AppDescriptor app,
	        @RequestParam(value = "breadcrumbOverride", required = false) String breadcrumbOverride,
	        @RequestParam(value = "fromDate", required = false) Date fromDate,
	        @RequestParam(value = "toDate", required = false) Date toDate, UiSessionContext sessionContext, PageModel model,
	        UiUtils ui) {
		List<Alert> alerts = new ArrayList();
		alerts = Context.getAlertService().getAllActiveAlerts(sessionContext.getCurrentUser());
		List<PatientQueue> patientQueueList = new ArrayList();
		try {
			patientQueueList = ((UgandaEMRPOCService) Context.getService(UgandaEMRPOCService.class)).getPatientInQueueList(
			    sessionContext.getCurrentProvider(), dateFormtter(new Date(), "00:00:00"),
			    dateFormtter(new Date(), "23:59:59"), sessionContext.getSessionLocation());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		pageModel.put("patientQueueList", patientQueueList);
		pageModel.put("alerts", alerts);
		
		model.addAttribute("afterSelectedUrl", app.getConfig().get("afterSelectedUrl").getTextValue());
		model.addAttribute("heading", app.getConfig().get("heading").getTextValue());
		model.addAttribute("label", app.getConfig().get("label").getTextValue());
		model.addAttribute("showLastViewedPatients",
		    Boolean.valueOf(app.getConfig().get("showLastViewedPatients").getBooleanValue()));
		org.openmrs.module.coreapps.helper.BreadcrumbHelper.addBreadcrumbsIfDefinedInApp(app, model, ui);
	}
	
	public Date dateFormtter(Date date, String time) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		SimpleDateFormat formatterExt = new SimpleDateFormat("dd/MM/yyyy");
		
		String formattedDate = formatterExt.format(date) + " " + time;
		
		return formatter.parse(formattedDate);
	}
}
