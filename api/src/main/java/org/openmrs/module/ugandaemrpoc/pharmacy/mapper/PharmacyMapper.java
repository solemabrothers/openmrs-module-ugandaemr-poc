package org.openmrs.module.ugandaemrpoc.pharmacy.mapper;

import org.openmrs.module.patientqueueing.mapper.PatientQueueMapper;

import java.io.Serializable;
import java.util.Set;

public class PharmacyMapper extends PatientQueueMapper implements Serializable {

    Integer visitId;

    Set<DrugOrderMapper> drugOrderMappers;

    public PharmacyMapper() {
    }

    public Set<DrugOrderMapper> getOrderMapper() {
        return drugOrderMappers;
    }

    public void setDrugOrderMapper(Set<DrugOrderMapper> orderMapper) {
        this.drugOrderMappers = orderMapper;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public void setDateChanged(String toString) {
    }
}