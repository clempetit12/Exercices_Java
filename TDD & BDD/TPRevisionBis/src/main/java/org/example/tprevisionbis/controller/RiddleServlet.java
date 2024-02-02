package org.example.tprevisionbis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tprevisionbis.entities.Riddle;
import org.example.tprevisionbis.repository.RiddleRepository;
import org.example.tprevisionbis.service.RiddleService;
import org.example.tprevisionbis.util.HibernateSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "riddle", value = "/riddle")
public class RiddleServlet extends HttpServlet {

    private RiddleService riddleService;

    public void init() {
        riddleService = new RiddleService(new RiddleRepository(), HibernateSession.getSessionFactory());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        switch (action) {
            case "/insert":
                addRiddle(request, response);
                break;
            case "/get":
                getRiddle(request, response);
                break;
            case "/check":
                checkUserAnswer(request, response);
                break;
            case "/getAll":
                getAllRiddle(request, response);
                break;
        }
    }

    private void getAllRiddle(HttpServletRequest request, HttpServletResponse response) {
        try{
            List<Riddle> riddleList = riddleService.getAllRiddle();
            request.setAttribute("riddles", riddleList);
            request.getRequestDispatcher("patients.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void getRiddle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Riddle riddle = riddleService.findRiddle(id);
        request.setAttribute("riddle", riddle);
        request.getRequestDispatcher("riddleDisplay.jsp").forward(request, response);
    }

    private void addRiddle(HttpServletRequest request, HttpServletResponse response) {
        try {
            String riddleText = request.getParameter("riddleText");
            String expectedAnswer = request.getParameter("expectedAnswer");
           Riddle riddle = new Riddle(riddleText,expectedAnswer);
            if (riddleService.create(riddle)) {
                System.out.println("Une devinette a bien été créée");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkUserAnswer(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String userAnswer = request.getParameter("userAnswer");
            if (riddleService.checkUserAnswer(userAnswer,id)) {
                System.out.println("Vous avez trouvé la réponse à la devinette");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
