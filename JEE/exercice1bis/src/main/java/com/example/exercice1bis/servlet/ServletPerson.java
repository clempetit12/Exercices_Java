package com.example.exercice1bis.servlet;

import com.example.exercice1bis.dao.UserDao;
import com.example.exercice1bis.entity.User;
import com.example.exercice1bis.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="user", value="/user")
public class ServletPerson extends HttpServlet {


        private List<User> userList;
        private UserDao userDao;
        private UserService userService;

        @Override
        public void init() throws ServletException {
            userList = new ArrayList<>();
            userDao = new UserDao();
            userService = new UserService(userDao);

        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("authentification.jsp").forward(req, resp);
        }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user1 = new User(email, password);
            userService.createUser(user1);
            req.setAttribute("users", userList);
            req.getRequestDispatcher("product-form.jsp").forward(req, resp);

        }

}
