package org.example.tp_blog.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tp_blog.entity.User;
import org.example.tp_blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService{

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    @Override
    public User saveNewUser(String username, String password, String rePwd, String roles) {
        if (!password.equals(rePwd)) throw new  RuntimeException("Password not match");
        String hashedPWD = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPWD);
        user.setRoles(roles);
        User savedAppUser = userRepository.save(user);
        return savedAppUser;
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
