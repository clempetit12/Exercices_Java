package com.example.tp_hopital.services;

import com.example.tp_hopital.dao.CareFileDao;
import com.example.tp_hopital.dao.ConsultationDao;
import com.example.tp_hopital.dao.PatientDao;
import com.example.tp_hopital.dao.PrescriptionDao;
import com.example.tp_hopital.entities.CareFile;
import com.example.tp_hopital.entities.Consultation;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.entities.Prescription;

import java.util.List;

public class HopitalService {

    private PatientDao patientDao;

    private ConsultationDao consultationDao;

    private CareFileDao careFileDao;
    private PrescriptionDao prescriptionDao;

    public HopitalService(PatientDao patientDao,ConsultationDao consultationDao,CareFileDao careFileDao,PrescriptionDao prescriptionDao) {
        this.patientDao = patientDao;
        this.consultationDao = consultationDao;
        this.careFileDao =careFileDao;
        this.prescriptionDao = prescriptionDao;
    }


    public boolean createPatient(Patient patient) {
        return patientDao.create(patient);
    }

    public List<Patient> getPatientList() {
        return patientDao.findAll();
    }

    public List<Patient> getByName(String name) {
        return patientDao.findByName(name);
    }

    public Patient getPatientById(Long id) {
        return patientDao.findById(id);
    }

    public boolean createConsultation(Consultation consultation) {
        return consultationDao.create(consultation);
    }

    public Consultation getConsultationById(Long id) {
        return consultationDao.findById(id);
    }

    public List<Consultation> findConsultationByPatient(Long id) {
        return consultationDao.findConsultationByIdPatient(id);
    }


    public boolean createPrescription(Prescription prescription) {
        return prescriptionDao.create(prescription);
    }
    public boolean createCareFile(CareFile careFile) {
        return careFileDao.create(careFile);
    }
    public boolean deletePatient(Patient patient) {
        return patientDao.delete(patient);
    }
    public boolean updateConsultation(Consultation consultation) {
        return consultationDao.update(consultation);
    }

    public CareFile getFileCare(Long id) {
        return careFileDao.findById(id);
    }
    public Prescription getPrescription(Long id) {
        return prescriptionDao.findById(id);
    }
}
