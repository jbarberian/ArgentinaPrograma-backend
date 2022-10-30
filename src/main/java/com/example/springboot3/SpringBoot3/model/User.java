package com.example.springboot3.SpringBoot3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    //@Column
    //private String email;
    
    @Column(unique = true)
    private String username;
    
    @Column
    private String password;

    public User() {
    }

    //public User(String email, String username, String password) {
    public User(String username, String password) {
        //this.email = email;
        this.username = username;
        this.password = password;
    }

}
