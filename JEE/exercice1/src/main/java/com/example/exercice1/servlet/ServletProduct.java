package com.example.exercice1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "produit", value = "/produit")
public class ServletProduct extends HttpServlet {

    private List<entity.Product> productList;

    @Override
    public void init() throws ServletException {



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProduct = req.getParameter("idProduct") ;

        String brand = req.getParameter("brand");
        String priceString  = req.getParameter("price");
        double price = Double.parseDouble(priceString);
        req.getRequestDispatcher("product-list.jsp").forward(req,resp);

    }
}
