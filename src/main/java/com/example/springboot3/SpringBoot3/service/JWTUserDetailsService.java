package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.DTO.UserDTO;
import com.example.springboot3.SpringBoot3.model.User;
import com.example.springboot3.SpringBoot3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class JWTUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PasswordEncoder bcryptEncoder;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = (User) userRepo.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Username not found: "+username);
        }
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), new ArrayList<>());
    }
    
    // Deberia ser public User... de la otra manera
    public User save(UserDTO user) {
        
        //User userDB = (User) userRepo.findByUsername(user.getUsername());
        
        //if (userDB != null) {
        //    return HttpStatus.BAD_REQUEST;
        //}
        
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepo.save(newUser);
    }
}
