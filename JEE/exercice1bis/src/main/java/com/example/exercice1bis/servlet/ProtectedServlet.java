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


@WebServlet(name = "protected", value = "/protected")
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
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user = new User(email, password);
            if (userService.getByNamePassword(user)) {
                HttpSession session = req.getSession();

                boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged") : false;
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Logged: " + logged);

                if (!logged) {
                    req.setAttribute("message", "Pas connecté");
                    session.setAttribute("isLogged", false);
                    System.out.println("connecté");
                } else {
                    req.setAttribute("message", "Connecté");
                    session.setAttribute("isLogged", true);
                    System.out.println("non connecté ");
                }
            } else {
                req.setAttribute("message", "Erreur d'authentification");
            }

            req.getRequestDispatcher("autentification-valide.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}










