package com.example.tp_hopital.controller;

import com.example.tp_hopital.entity.CareFile;
import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.entity.Prescription;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.ConsultationRepository;
import com.example.tp_hopital.repository.PatientRepository;
import com.example.tp_hopital.service.ConsultationService;
import com.example.tp_hopital.service.PatientService;
import com.example.tp_hopital.util.Definition;
import com.example.tp_hopital.util.HibernateSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.hibernate.Session;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet(name = "patient", value = "/patient")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    private ConsultationService consultationService;


    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory(), new PatientRepository()  );
        consultationService = new ConsultationService(HibernateSession.getSessionFactory(), new ConsultationRepository());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/listPatients":
                    showPatients(request, response);
                    break;
                case "/insert":
                    addPatient(request, response);
                    break;
                case "/form":
                    showNewForm(request, response);
                    break;
                case "/search":
                    searchPatient(request, response);
                    break;
                case "/delete":
                    deletePatients(request, response);
                    break;
                case "/details":
                    detailsPatient(request, response);
                    break;
                case "/formConsultation":
                    showFormConsultation(request, response);
                    break;
                case "/insertConsultation":
                    addConsultation(request, response);
                    break;
                case "/detailsConsultation":
                    showDetailConsultation(request, response);
                    break;

                default:
                    response.sendRedirect("/listPatients");
                    break;


            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }

    private void searchPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("search patient");
        String name =request.getParameter("lastName");
        System.out.println(name);
//        List<Patient> patients = patientService.getByName(name);
//        System.out.println(patients);
//        request.setAttribute("patientsName", patients);
//        request.getRequestDispatcher(Definition.VIEW_PATH + "patientList-filtered.jsp").forward(request,response);
    }


    private void showPatients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        try{
            List<Patient> patientList = patientService.getAllPatient();
            request.setAttribute("patients", patientList);
            request.getRequestDispatcher("patients.jsp").forward(request,response);
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }

    }

    private void showFormConsultation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("formConsultation");
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH + "form-consultation.jsp");
        dispatcher.forward(request, response);
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Part imagePart = request.getPart("image");
        System.out.println(imagePart);
        String fileType = imagePart.getContentType();
        try
        {
            if(fileType.equalsIgnoreCase("image/png")){

                byte[] imageBytes = null;
                if (imagePart != null) {
                    InputStream inputStream = imagePart.getInputStream();
                    imageBytes = inputStream.readAllBytes();
                }
                System.out.println("image" + imageBytes);
                String lastName = request.getParameter("lastName");
                System.out.println(lastName);
                String firstName = request.getParameter("firstName");
                System.out.println(firstName);
                String dateOfBirthString = request.getParameter("dateOfBirth");
                System.out.println(dateOfBirthString);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(dateOfBirthString);

                Patient patient = new Patient(lastName,firstName,date,imageBytes) ;

                Long id = request.getParameter("id") !=null ? Long.valueOf(request.getParameter("id")) : null;

                if(id != null){
                    patient.setId(id);
                }

                if(patientService.createPatient(patient)) {
                    response.sendRedirect("listPatients");
                }else{
                    response.sendRedirect(Definition.VIEW_PATH+"form-patient.jsp");
                }
            }else{
                response.sendRedirect(Definition.VIEW_PATH+"form-patient.jsp");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("form");
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH + "form-patient.jsp");
        dispatcher.forward(request, response);

    }
    private void deletePatients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Long id = Long.parseLong(request.getParameter("id"));
            Patient patient = patientService.getOnePatient(id);
            if(patient != null){
                if( patientService.deletePatient(patient)) {
                    System.out.println("Le patient à bien été supprimé avec id " + patient.getId());
                }
                response.sendRedirect("listPatients");
            }

        }catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }

    }
    private void detailsPatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            if(request.getParameter("id") != null) {
                Long id = Long.parseLong(request.getParameter("id"));
                Patient patient = patientService.getOnePatient(id);
                request.setAttribute("patient", patient);
                request.getRequestDispatcher(Definition.VIEW_PATH+"patient.jsp").forward(request,response);
            }
            else {
                request.setAttribute("patients", patientService.getAllPatient());
                request.getRequestDispatcher(Definition.VIEW_PATH+"patients.jsp").forward(request,response);
            }
        }catch (RepositoryException r) {
            System.out.println(r.getMessage());
        }


    }

    private void showDetailConsultation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            if(request.getParameter("id") != null) {
                Long id = Long.parseLong(request.getParameter("id"));
                Consultation consultation = consultationService.getConsultationById(id);
                request.setAttribute("consultation", consultation);
                request.getRequestDispatcher(Definition.VIEW_PATH+"consultation.jsp").forward(request,response);
            }
            else {
                request.setAttribute("patients", patientService.getAllPatient());
                request.getRequestDispatcher(Definition.VIEW_PATH+"patients.jsp").forward(request,response);
            }

        }catch (RepositoryException r) {
            System.out.println(r.getMessage());
        }


    }

    private void addConsultation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            String doctorName = request.getParameter("doctorName");
            System.out.println(doctorName);
            String dateOfConsultation = request.getParameter("dateConsultation");
            System.out.println(dateOfConsultation);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(dateOfConsultation);
            Long patientId = Long.parseLong(request.getParameter("patientId"));
            System.out.println(patientId);
            Consultation consultation = new Consultation();
            consultation.setDoctorName(doctorName);
            consultation.setConsultationDate(date);
            Patient patient = patientService.getOnePatient(patientId);
            consultation.setPatient(patient);
            consultationService.createConsultation(consultation);

            String[] careArray = request.getParameterValues("care[]");
            System.out.println(careArray);
            String[] durationArray = request.getParameterValues("duration[]");
            String[] medicationArray = request.getParameterValues("medication[]");
            String[] durationMArray = request.getParameterValues("durationM[]");

            if (consultation.getCareFile() == null) {
                consultation.setCareFile(new ArrayList<>());
            }

            if (consultation.getPrescription() == null) {
                consultation.setPrescription(new ArrayList<>());
            }

            for (int i = 0; i < careArray.length; i++) {
                CareFile careFile = new CareFile();
                careFile.setCare(careArray[i]);
                careFile.setDuration(durationArray[i]);
                careFile.setConsultation(consultation);
                consultation.getCareFile().add(careFile);
            }


            for (int i = 0; i < medicationArray.length; i++) {
                Prescription prescription = new Prescription();
                prescription.setMedication(medicationArray[i]);
                prescription.setDuration(Integer.parseInt(durationMArray[i]));
                prescription.setConsultation(consultation);
                consultation.getPrescription().add(prescription);
            }

            consultationService.updateConsultation(consultation);
            response.sendRedirect("patients.jsp");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }


}
