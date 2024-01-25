package com.example.exercice1bis.servlet;

import com.example.exercice1bis.dao.UserDao;
import com.example.exercice1bis.entity.User;
import com.example.exercice1bis.service.UserService;
import com.example.exercice1bis.utils.Definition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "user", value = "/user")
public class ProtectedServlet extends HttpServlet {

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
        req.getRequestDispatcher("autentification-valide.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(email, password);
            User user1 = userService.getByNamePassword(user);
            if (user1 != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user",user.getEmail());
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("userEmail", user.getEmail());
                System.out.println(userName);
                userName.setMaxAge(30*60);
                resp.addCookie(userName);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                req.setAttribute("message", "Connecté");
                resp.sendRedirect("index.jsp");


            }
            else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                PrintWriter out= resp.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(req, resp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}