package com.example.exercice1bis.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "produitForm", value = "/produitForm")
public class ServletForm extends HttpServlet {

    private List<entity.Product> productList;

    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {

        productDao = new dao.ProductDao();
        productService = new service.ProductService(productDao);
        productList = productService.getAllProducts();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("product-form.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String priceStr = req.getParameter("price");
        Double price = 0.0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {

            e.printStackTrace();
        }
        entity.Product product = new entity.Product(brand, price);
        productService.createProduct(product);
        req.setAttribute("produits", productList);
        req.getRequestDispatcher("product-form.jsp").forward(req, resp);

    }
}
