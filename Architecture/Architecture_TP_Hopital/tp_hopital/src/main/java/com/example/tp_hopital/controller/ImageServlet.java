package com.example.tp_hopital.controller;

import com.example.tp_hopital.entity.CareFile;
import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.entity.Prescription;
import com.example.tp_hopital.repository.Repository;
import com.example.tp_hopital.service.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {

    private PatientService patientService;

    private Repository<Patient> patientRepository;

    private Repository<Consultation> consultationRepository;

    private Repository<Prescription> prescriptionRepository;

    private Repository<CareFile> careFileRepository;


    private PatientDao patientDao;

    private ConsultationDao consultationDao;

    private CareFileDao careFileDao;
    private PrescriptionDao prescriptionDao;

    public void init() {

        patientDao = new PatientDao();
        consultationDao = new ConsultationDao();
        careFileDao = new CareFileDao();
        prescriptionDao = new PrescriptionDao();
        hopitalService = new HopitalService(patientDao,consultationDao,careFileDao,prescriptionDao);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Patient patient = hopitalService.getPatientById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (patient.getImage() != null) {
            out.write(patient.getImage());
        } else {
            out.write(null);
        }
        out.close();
    }


}
