package org.example.tp_blog;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.example.tp_blog.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;

@SpringBootApplication
public class TpBlogApplication {
    public static void main(String[] args) {

       SpringApplication.run(TpBlogApplication.class);

    }


    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("petit","1234","ROLE_ADMIN");



        };
    }

}
