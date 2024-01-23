package com.example.exercice1bis.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "produitDetail", value = "/produitDetail")
public class ServletDetail extends HttpServlet {
    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {
        productDao = new dao.ProductDao();
        productService = new service.ProductService(productDao);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long idP ;
        idP = Long.parseLong(id);
        entity.Product product = productService.getProductById(idP);
        req.setAttribute("produit", product);
        req.getRequestDispatcher("product-detail.jsp").forward(req,resp);

    }
}
