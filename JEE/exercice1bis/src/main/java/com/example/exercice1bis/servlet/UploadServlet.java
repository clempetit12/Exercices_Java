package com.example.exercice1bis.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "upload",value = "/upload")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("/") + "images";

        File file = new File(uploadPath);

        if(!file.exists()){
            file.mkdir();
        }

        Part image = req.getPart("image");

        String fileName = image.getSubmittedFileName();

        image.write(uploadPath + File.separator + fileName);
        resp.sendRedirect("product-list.jsp");


    }
}
