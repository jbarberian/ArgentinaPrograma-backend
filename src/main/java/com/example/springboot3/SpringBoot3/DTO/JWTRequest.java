package com.example.springboot3.SpringBoot3.DTO;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class JWTRequest {
    
    private String username;
    private String password;  
}
