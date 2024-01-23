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


@WebServlet(name="protected", value="/protected")
    public class ProtectedServlet extends HttpServlet {

    private List<User> userList;
        private UserDao userDao;
        private UserService userService;
        @Override
        public void init() throws ServletException {
            userList= new ArrayList<>();
            userDao = new UserDao();
            userService = new UserService(userDao);

        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String email = req.getParameter("email");
            String password = req.getParameter("password");


            HttpSession session = req.getSession();
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");

            boolean logged = (session.getAttribute("isLogged")!=null) ? (boolean) session.getAttribute("isLogged") :false;

            if(!logged){
                out.println("<div> Pas connecté </div>");
            }else{
                out.println("<div>Connecté</div>");
            }
            out.println("</body></html>");
        }




}
