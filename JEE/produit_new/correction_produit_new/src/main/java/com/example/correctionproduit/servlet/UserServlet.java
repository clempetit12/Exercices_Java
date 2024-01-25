package com.example.correctionproduit.servlet;


import com.example.correctionproduit.entities.User;
import com.example.correctionproduit.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name="user", value="/user")
public class UserServlet extends HttpServlet {

        private UserService userService;

        @Override
        public void init() throws ServletException {
            userService = new UserService();

        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String name = req.getParameter("name");

            if(email != null && password != null && name != null){
                User user1 = new User(email,password,name);
                if(userService.create(user1)){
                    resp.sendRedirect("login.jsp");
                }else{
                    resp.sendRedirect("register.jsp");
                }

            }else if(email != null && password != null){
                User user2 = new User(email,password);
               if(userService.getByEmailPassword(user2)){
                   HttpSession session = req.getSession();
                   session.setAttribute("isLogged", true);
                   resp.sendRedirect("list");
               }
            }else{
                resp.sendRedirect("login.jsp");
            }



        }

}
