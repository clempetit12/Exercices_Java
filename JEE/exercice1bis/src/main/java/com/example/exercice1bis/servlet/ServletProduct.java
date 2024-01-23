package com.example.exercice1bis.servlet;

import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "produit", value = "/produit")
public class ServletProduct extends HttpServlet {

    private List<entity.Product> productList;

    private List<entity.Product> productListprice;
    private static dao.ProductDao productDao;
    private service.ProductService productService;

    @Override
    public void init() throws ServletException {
        productList = new ArrayList<>();
        productDao = new ProductDao();
        productService = new ProductService(productDao);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brand = req.getParameter("brand");
        productList = productService.getAllProducts();
        req.setAttribute("produits", productList);
        req.getRequestDispatcher("product-list.jsp").forward(req,resp);

    }



    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long idP ;
        idP = Long.parseLong(id);
        entity.Product product = productService.getProductById(idP);
        productService.deleteProduct(product.getIdProduct());
    }


}
