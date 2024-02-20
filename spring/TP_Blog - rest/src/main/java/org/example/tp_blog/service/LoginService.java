package org.example.tp_blog.service;

import jakarta.servlet.http.HttpSession;
import org.example.tp_blog.entity.Users;
import org.example.tp_blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserRepository userRepository;

    @Autowired
    private HttpSession _httpSession;

    public boolean login(Users users) {
        if (userRepository.equals(users)) {
            _httpSession.setAttribute("login", "OK");
            return true;
        }
        return false;
    }

    public boolean isLogged() {
        try {
            String attrIsLogged = _httpSession.getAttribute("login").toString();
            return attrIsLogged.equals("OK");
        } catch (Exception ex) {
            return false;
        }

    }
}
