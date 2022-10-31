package com.example.springboot3.SpringBoot3.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JWTConfig {
    
	@Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
	}
    
}
