package com.example.springboot3.SpringBoot3.controller;

import com.example.springboot3.SpringBoot3.DTO.JWTRequest;
import com.example.springboot3.SpringBoot3.DTO.JWTResponse;
import com.example.springboot3.SpringBoot3.DTO.UserDTO;
import com.example.springboot3.SpringBoot3.auth.JWTtokenUtil;
import com.example.springboot3.SpringBoot3.service.JWTUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private JWTtokenUtil tokenUtil;
    
    @Autowired
    private JWTUserDetailsService uDetailsServ;
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(uDetailsServ.save(user));
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authRequest) throws Exception {
        
        authenticate(authRequest.getUsername(), authRequest.getPassword());
        final UserDetails uDetails = uDetailsServ.loadUserByUsername(authRequest.getUsername());
        final String token = tokenUtil.generateToken(uDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }
        
    private void authenticate(String username, String password) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            } catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
	    }
}
    
    
    
}
