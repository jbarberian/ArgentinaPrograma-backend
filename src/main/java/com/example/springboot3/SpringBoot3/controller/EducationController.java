package com.example.springboot3.SpringBoot3.controller;

import com.example.springboot3.SpringBoot3.model.Education;
import com.example.springboot3.SpringBoot3.service.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired
    private IEducationService edServ;
    
    /*Create Method (C)*/
    @PostMapping("/new/ed")
    public void createEducation(@RequestBody Education ed){
        edServ.createEducation(ed);
    }
        
    /*Read Method (R)*/
    @GetMapping("/findall/ed")
    @ResponseBody
    public List<Education> findAllEducations(){
        return edServ.findAllEducations();
    }
    
    @GetMapping("/find/ed/{id}")
    public Education findPerson(@PathVariable Long id){
        return edServ.findEducation(id);
    }
    
    /*Update Method (U)*/
    @PutMapping("/update/ed/{id}")
    public void updateEducation(@PathVariable Long id, @RequestBody Education newEducation){
        
        Education ed = edServ.findEducation(id);
        ed.setTitle(newEducation.getTitle());
        ed.setCompany(newEducation.getCompany());
        ed.setDatespan(newEducation.getDatespan());
        ed.setDescription(newEducation.getDescription());
        ed.setAvatarURL(newEducation.getAvatarURL());
        
        edServ.createEducation(ed);
    }
    
    
    /*@PutMapping("/update/ed/{id}")
    public void updateEducation(@PathVariable Long id,
            @RequestParam String title,
            @RequestParam String company,
            @RequestParam String datespan,
            @RequestParam String description,
            @RequestParam String avatarURL){
        
        Education ed = edServ.findEducation(id);
        ed.setTitle(title);
        ed.setCompany(company);
        ed.setDatespan(datespan);
        ed.setDescription(description);
        ed.setAvatarURL(avatarURL);
        edServ.createEducation(ed);
    }
    */
    
    /*Delete Method (D)*/
    @DeleteMapping("/delete/ed/{id}")
    public void deleteEducation(@PathVariable Long id){
        edServ.deleteEducation(id);
    }   
}