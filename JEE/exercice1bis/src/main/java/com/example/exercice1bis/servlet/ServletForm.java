package com.example.exercice1bis.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class ServletForm extends HttpServlet {

    private List<entity.Product> productList;

    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {

        productDao = new dao.ProductDao();
        productService = new service.ProductService(productDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showForm(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                default:
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/insert":
                    processForm(req, resp, false);
                    break;
                case "/update":
                    processForm(req, resp, true);
                    break;
                default:
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        Long idP;
        idP = Long.parseLong(id);
        System.out.println("id " + idP);
        entity.Product produit = productService.getProductById(idP);
        System.out.println(produit);
        request.setAttribute("produit", produit);
        request.getRequestDispatcher("product-form.jsp").forward(request, response);

    }

    private void showForm(HttpServletRequest req, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        req.getRequestDispatcher("product-form.jsp").forward(req, response);
    }

    private void processForm(HttpServletRequest req, HttpServletResponse response, boolean isUpdate)
            throws SQLException, IOException, ServletException {
        String brand = req.getParameter("brand");
        String priceStr = req.getParameter("price");
        Double price = 0.0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        entity.Product product = new entity.Product(brand, price);
        System.out.println("new product" + product);
        if (isUpdate) {
            String id = req.getParameter("id");
            Long idP = Long.parseLong(id);
            productService.updateProduct(idP, product);
        } else {
            productService.createProduct(product);
        }

        req.setAttribute("produits", productList);
        response.sendRedirect("index.jsp");
    }

}


