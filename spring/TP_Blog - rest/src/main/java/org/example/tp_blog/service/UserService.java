package org.example.tp_blog.service;

import org.example.tp_blog.dto.UsersDto;
import org.example.tp_blog.entity.Users;
import org.example.tp_blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;



    public Users loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    public Users save (UsersDto usersDto) {
        String hashedPassword = hashPassword(usersDto.getPassword());
        usersDto.setPassword(hashedPassword);
        System.out.println("save users");
       return userRepository.save(usersDto.toUsers());
    }

    public List<UsersDto> findAllUsers() {
        return userRepository.findAll().stream().map(users -> users.toUsersDto()).toList();
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public String getUserRoles() {
        return userRepository.findByRole();
    }
}
