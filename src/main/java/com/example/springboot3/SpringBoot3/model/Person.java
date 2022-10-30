package com.example.springboot3.SpringBoot3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String position;
    private String description;
    private String avatarURL;
    private String coverURL;

    public Person() {
    }

    public Person(Long id, String name, String position, String description, String avatarURL, String coverURL) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.description = description;
        this.avatarURL = avatarURL;
        this.coverURL = coverURL;
    }
}