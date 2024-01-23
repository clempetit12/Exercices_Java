package com.example.exercice1bis.servlet;

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

@WebServlet(name = "produitDate", value = "/produitDate")
public class ServletProductDate extends HttpServlet {

    private List<entity.Product> productList;

    private List<entity.Product> productListdate;
    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {
        productListdate = new ArrayList<>();
        productDao = new dao.ProductDao();
        productService = new service.ProductService(productDao);

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            String brand = req.getParameter("brand");
            String date_string = "12-03-2023";
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = formatter.parse(date_string);
            String date_string2 = "25-08-2023";
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
            Date date2 = formatter2.parse(date_string2);
            productListdate = productService.getProductsByDate(date1,date2);
            req.setAttribute("produits3", productListdate);
            req.getRequestDispatcher("product-list-date.jsp").forward(req,resp);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
