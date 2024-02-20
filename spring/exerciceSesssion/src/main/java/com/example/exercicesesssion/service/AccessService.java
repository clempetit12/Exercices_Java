package com.example.exercicesesssion.service;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccessService {

    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    @Autowired
    private HttpSession httpSession;

    public boolean getSession(String loginWritten, String passwordWritten) {
        if (loginWritten.equals(LOGIN) && passwordWritten.equals(PASSWORD)) {
            httpSession.setAttribute("login", "OK");
            return true;
        }

        return false;
    }

    public boolean isLogged() {
        try {
            String attIsLogged = httpSession.getAttribute("login").toString();
            return attIsLogged.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }

}
