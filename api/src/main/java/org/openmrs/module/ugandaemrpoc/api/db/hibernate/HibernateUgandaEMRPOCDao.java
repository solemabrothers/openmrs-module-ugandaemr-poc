package org.openmrs.module.ugandaemrpoc.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Provider;
import org.openmrs.module.ugandaemrpoc.api.db.UgandaEMRPOCDao;
import org.openmrs.module.ugandaemrpoc.model.PatientQue;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class HibernateUgandaEMRPOCDao implements UgandaEMRPOCDao {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	private SessionFactory sessionFactory;
	
	public HibernateUgandaEMRPOCDao() {
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public PatientQue getPatientQueById(String id) {
		return (PatientQue) getCurrentSession().createCriteria(PatientQue.class).add(Restrictions.eq("uuid", id))
		        .uniqueResult();
	}
	
	public List<PatientQue> getPatientQueByPatient(Patient patient) {
		Criteria criteria = getCurrentSession().createCriteria(PatientQue.class);
		criteria.add(Restrictions.eq("patient", patient));
		return criteria.list();
	}
	
	public PatientQue savePatientQue(PatientQue patientQue) {
		try {
			getCurrentSession().saveOrUpdate(patientQue);
			return patientQue;
		}
		catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public List<PatientQue> getPatientInQue(Provider provider, Date fromDate, Date toDate, Location sessionLocation) {
		Criteria criteria = getCurrentSession().createCriteria(PatientQue.class);
		criteria.add(Restrictions.between("dateCreated", fromDate, toDate));
		criteria.add(Restrictions.eq("provider", provider));
		criteria.add(Restrictions.eq("locationTo", sessionLocation));
		return criteria.list();
	}
	
	private Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		}
		catch (NoSuchMethodError ex) {
			try {
				Method method = sessionFactory.getClass().getMethod("getCurrentSession", null);
				return (Session) method.invoke(sessionFactory, null);
			}
			catch (Exception e) {
				log.error("Failed to get the hibernate session", e);
			}
		}
		
		return null;
	}
}
