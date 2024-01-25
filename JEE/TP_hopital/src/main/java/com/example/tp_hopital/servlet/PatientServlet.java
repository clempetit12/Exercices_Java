package com.example.tp_hopital.servlet;

import com.example.tp_hopital.dao.CareFileDao;
import com.example.tp_hopital.dao.ConsultationDao;
import com.example.tp_hopital.dao.PatientDao;
import com.example.tp_hopital.dao.PrescriptionDao;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.services.HopitalService;
import com.example.tp_hopital.utils.Definition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet extends HttpServlet {

private HopitalService hopitalService;
private PatientDao patientDao;

private ConsultationDao consultationDao;

private CareFileDao careFileDao;
private PrescriptionDao prescriptionDao;

private List<Patient> patientList;

    @Override
    public void init() throws ServletException {
patientList = new ArrayList<>();
        patientDao = new PatientDao();
        consultationDao = new ConsultationDao();
        careFileDao = new CareFileDao();
        prescriptionDao = new PrescriptionDao();
        hopitalService = new HopitalService(patientDao,consultationDao,careFileDao,prescriptionDao);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        patientList = hopitalService.getPatientList();
        for (Patient patient : patientList
        ) {
            System.out.println(patient.getIdPatient());
        }
        request.setAttribute("patients", patientList);

        request.getRequestDispatcher("patients.jsp").forward(request,response);
        HttpSession session = request.getSession();

        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean)session.getAttribute("isLogged") : false;

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
        String name =request.getParameter("lastName");
        List<Patient> patients = hopitalService.getByName(name);
        request.setAttribute("patientsName", patientList);
        request.getRequestDispatcher("patients.jsp").forward(request,response);
    }


    private void showPatients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        patientList = hopitalService.getPatientList();
        for (Patient patient : patientList
        ) {
            System.out.println(patient.getIdPatient());
        }
        request.setAttribute("patients", patientList);

        request.getRequestDispatcher("patients.jsp").forward(request,response);
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
            patient.setIdPatient(id);
        }

        if(hopitalService.createPatient(patient)) {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-patient.jsp");
        dispatcher.forward(request, response);
    }
//
//    private void showProduct(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//
//        if(request.getParameter("id") != null) {
//            int id = Integer.parseInt((request.getParameter("id")));
//            Produit produit = service.findById(id);
//            request.setAttribute("produit", produit);
//            request.getRequestDispatcher(Definition.VIEW_PATH+"produit.jsp").forward(request,response);
//        }
//        else {
//            request.setAttribute("produits", service.findAll());
//            request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
//        }
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        Produit existingProduit = service.findById(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-produit.jsp");
//        request.setAttribute("produit", existingProduit);
//        dispatcher.forward(request, response);
//
//
//    }
//
//    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//
//        Part imagePart = request.getPart("image");
//
//        String fileType = imagePart.getContentType();
//
//        if(fileType.equalsIgnoreCase("image/png")){
//
//            byte[] imageBytes = null;
//            if (imagePart != null) {
//                InputStream inputStream = imagePart.getInputStream();
//                imageBytes = inputStream.readAllBytes();
//            }
//            String marque = request.getParameter("marque");
//            String reference = request.getParameter("reference");
//            int stock = Integer.parseInt(request.getParameter("stock"));
//            double prix = Double.parseDouble(request.getParameter("prix"));
//            LocalDate dateAchat = LocalDate.parse(request.getParameter("dateAchat"));
//
//            Produit produit = new Produit(marque, reference, Date.from(dateAchat.atStartOfDay(ZoneId.systemDefault()).toInstant()), prix, stock, imageBytes);
//
//            Integer id = request.getParameter("id") !=null ? Integer.valueOf(request.getParameter("id")) : null;
//
//            if(id != null){
//                produit.setId(id);
//            }
//
//            if(service.create(produit)) {
//                response.sendRedirect("list");
//            }else{
//                response.sendRedirect(Definition.VIEW_PATH+"form-produit.jsp");
//            }
//        }else{
//            response.sendRedirect(Definition.VIEW_PATH+"form-produit.jsp");
//        }
//    }
//
//
//    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Produit produit = service.findById(id);
//        if(produit != null){
//            service.delete(produit);
//        }
//        response.sendRedirect("list");
//    }

}
