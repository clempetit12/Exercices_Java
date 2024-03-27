package org.example.tp_blog.service;

import org.example.tp_blog.entity.User;

public interface SecurityService {
    User saveNewUser(String username, String password, String roles);
    User loadUserByUsername(String username);
}
