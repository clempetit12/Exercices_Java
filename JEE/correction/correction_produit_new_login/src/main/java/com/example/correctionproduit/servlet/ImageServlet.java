package com.example.correctionproduit.servlet;

import com.example.correctionproduit.entities.Produit;
import com.example.correctionproduit.services.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {
    private ProduitService service;

    public void init() {

        service = new ProduitService();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = service.findById(id);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        if (produit.getImage() != null) {
            out.write(produit.getImage());
        } else {
            out.write(null);
        }
        out.close();
    }
}
