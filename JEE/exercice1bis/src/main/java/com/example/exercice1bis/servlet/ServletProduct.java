package com.example.exercice1bis.servlet;

import com.example.exercice1bis.utils.Definition;
import dao.ProductDao;
import entity.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.ProductService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/")
public class ServletProduct extends HttpServlet {

    private List<entity.Product> productList;

    private List<entity.Product> productListprice;
    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {

        productDao = new ProductDao();
        productService = new ProductService(productDao);

    }

    @Override
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
                    insertUser(request, response);
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
        request.setAttribute("produits", productService.getAllProducts());
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
            Long id = Long.parseLong((request.getParameter("id")));
            entity.Product produit = productService.getProductById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher(Definition.VIEW_PATH+"produit.jsp").forward(request,response);
        }
        else {
            request.setAttribute("produits", productService.getAllProducts());
            request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {


    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String marque = request.getParameter("marque");
        String reference = request.getParameter("reference");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double prix = Double.parseDouble(request.getParameter("prix"));
        LocalDate dateAchat = LocalDate.parse(request.getParameter("dateAchat"));
        entity.Product produit = new Product(marque, reference, Date.from(dateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), prix, stock);

        if(productService.createProduct(produit)) {
            response.sendRedirect("list");
        }else{
            response.sendRedirect(Definition.VIEW_PATH+"form-produit.jsp");
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Product produit = productService.getProductById(id);
        if(produit != null){
            productService.deleteProduct(produit.getIdProduct());
        }
        response.sendRedirect("list");
    }
}
