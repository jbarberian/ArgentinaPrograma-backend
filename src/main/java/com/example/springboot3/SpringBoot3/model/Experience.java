package com.example.springboot3.SpringBoot3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    private String company;
    private String fromdate;
    private String todate;
    private String description;
    private String avatarURL;

    public Experience() {
    }

    public Experience(Long id, String title, String company, String fromdate, String todate, String description, String avatarURL) {
        this.id = id;        
        this.title = title;
        this.company = company;
        this.fromdate = fromdate;
        this.todate = todate;
        this.description = description;
        this.avatarURL = avatarURL;
    }
}
