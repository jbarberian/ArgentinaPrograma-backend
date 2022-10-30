package com.example.springboot3.SpringBoot3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String company;
    private String datespan;
    private String description;
    private String avatarURL;

    public Education() {
    }

    public Education(Long id, String title, String company, String datespan, String description, String avatarURL) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.datespan = datespan;
        this.description = description;
        this.avatarURL = avatarURL;
    }
}
