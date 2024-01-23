package com.example.exercice1bis.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "produitPrice", value = "/produitPrice")
public class ServletProductPrice extends HttpServlet {


    private List<entity.Product> productListprice;
    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {
        productListprice = new ArrayList<>();
        productDao = new dao.ProductDao();
        productService = new service.ProductService(productDao);

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brand = req.getParameter("brand");
        productListprice = productService.getProductsByPrice(42.0);
        req.setAttribute("produits2", productListprice);
        req.getRequestDispatcher("product-list-price.jsp").forward(req,resp);

    }
}
