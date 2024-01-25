package com.example.exercice1bis.servlet;


import com.example.exercice1bis.entity.User;
import com.example.exercice1bis.service.UserService;
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


@WebServlet(name="user", value="/user")
public class UserServlet extends HttpServlet {

    private UserService userService;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
        userService = new UserService(userDao);

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
            if(userService.createUser(user1)){
                resp.sendRedirect("login.jsp");
            }else{
                resp.sendRedirect("register.jsp");
            }

        }else if(email != null && password != null){
            User user2 = new User(email,password,name);
            if(userService.getByNamePassword(user2) != null){
                HttpSession session = req.getSession();
                session.setAttribute("isLogged", true);
                resp.sendRedirect("list");
            }
        }else{
            resp.sendRedirect("login.jsp");
        }



    }

}
