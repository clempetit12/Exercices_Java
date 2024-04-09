package org.example.tp_blog;

import org.example.tp_blog.entity.User;
import org.example.tp_blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminDataInitializer  {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        if (userRepository.count() == 0) {
//
//            User admin = new User();
//            admin.setEmail("admin@gmail.com");
//            admin.setPassword(passwordEncoder.encode("password"));
//            admin.setRole("ROLE_ADMIN");
//
//            userRepository.save(admin);
//        }
//    }
}
