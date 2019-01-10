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
import org.openmrs.module.ugandaemrpoc.model.PatientQueue;

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
	
	public PatientQueue getPatientQueueById(String id) {
		return (PatientQueue) getCurrentSession().createCriteria(PatientQueue.class).add(Restrictions.eq("uuid", id))
		        .uniqueResult();
	}
	
	public List<PatientQueue> getPatientQueueByPatient(Patient patient) {
		Criteria criteria = getCurrentSession().createCriteria(PatientQueue.class);
		criteria.add(Restrictions.eq("patient", patient));
		return criteria.list();
	}
	
	public PatientQueue savePatientQueue(PatientQueue patientQueue) {
		try {
			getCurrentSession().saveOrUpdate(patientQueue);
			return patientQueue;
		}
		catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public List<PatientQueue> getPatientInQueue(Provider provider, Date fromDate, Date toDate, Location sessionLocation) {
		Criteria criteria = getCurrentSession().createCriteria(PatientQueue.class);
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
