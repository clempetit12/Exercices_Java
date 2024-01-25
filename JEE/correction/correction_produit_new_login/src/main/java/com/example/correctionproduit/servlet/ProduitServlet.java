package com.example.correctionproduit.servlet;

import com.example.correctionproduit.entities.Produit;
import com.example.correctionproduit.services.ProduitService;
import com.example.correctionproduit.utils.Definition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class ProduitServlet extends HttpServlet {

    private ProduitService service;


    public void init() {

        service = new ProduitService();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean)session.getAttribute("isLogged") : false;

        if(logged){

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertProduct(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/details":
                    showProduct(request, response);
                    break;
                case "/update":
                    updateProduct(request, response);
                    break;
                case "/list":
                    listProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        }else{
            response.sendRedirect("login.jsp");
        }

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("produits", service.findAll());
        request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-produit.jsp");
        dispatcher.forward(request, response);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            Produit produit = service.findById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher(Definition.VIEW_PATH+"produit.jsp").forward(request,response);
        }
        else {
            request.setAttribute("produits", service.findAll());
            request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produit existingProduit = service.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-produit.jsp");
        request.setAttribute("produit", existingProduit);
        dispatcher.forward(request, response);


    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        Part imagePart = request.getPart("image");

        String fileType = imagePart.getContentType();

        if(fileType.equalsIgnoreCase("image/png")){

        byte[] imageBytes = null;
        if (imagePart != null) {
            InputStream inputStream = imagePart.getInputStream();
            imageBytes = inputStream.readAllBytes();
        }
        String marque = request.getParameter("marque");
        String reference = request.getParameter("reference");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double prix = Double.parseDouble(request.getParameter("prix"));
        LocalDate dateAchat = LocalDate.parse(request.getParameter("dateAchat"));

        Produit produit = new Produit(marque, reference, Date.from(dateAchat.atStartOfDay(ZoneId.systemDefault()).toInstant()), prix, stock, imageBytes);

        Integer id = request.getParameter("id") !=null ? Integer.valueOf(request.getParameter("id")) : null;

        if(id != null){
            produit.setId(id);
        }

        if(service.create(produit)) {
            response.sendRedirect("list");
        }else{
            response.sendRedirect(Definition.VIEW_PATH+"form-produit.jsp");
        }
        }else{
            response.sendRedirect(Definition.VIEW_PATH+"form-produit.jsp");
        }
    }


    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = service.findById(id);
        if(produit != null){
            service.delete(produit);
        }
        response.sendRedirect("list");
    }

}
