package com.example.tp_hopital.controller;

import com.example.tp_hopital.entity.CareFile;
import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.entity.Prescription;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.*;
import com.example.tp_hopital.service.ConsultationService;
import com.example.tp_hopital.service.PatientService;
import com.example.tp_hopital.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {

    private PatientService patientService;
    public ImageServlet(PatientService patientService) {
        this.patientService = patientService;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Patient patient = null;
        try {
            patient = patientService.getOnePatient(id);
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (patient.getImage() != null) {
            out.write(patient.getImage());
            System.out.println("pas d'image");
        } else {
            out.write(null);
        }
        out.close();
    }


}
