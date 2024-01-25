package com.example.tp_hopital.servlet;

import com.example.tp_hopital.dao.CareFileDao;
import com.example.tp_hopital.dao.ConsultationDao;
import com.example.tp_hopital.dao.PatientDao;
import com.example.tp_hopital.dao.PrescriptionDao;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.services.HopitalService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet
{
    private HopitalService hopitalService;
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
