package com.example.springboot3.SpringBoot3.controller;

import com.example.springboot3.SpringBoot3.model.Experience;
import com.example.springboot3.SpringBoot3.service.IExperienceService;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class ExperienceController {
    
    @Autowired
    private IExperienceService xpServ;
    
    /*Create Method (C)*/
    @PostMapping("/new/xp")
    public void createExperience(@RequestBody Experience xp){
        xpServ.createExperience(xp);
    }
        
    /*Read Method (R)*/
    @GetMapping("/findall/xp")
    @ResponseBody
    public List<Experience> findAllExperiences(){
        return xpServ.findAllExperiences();
    }
    
    @GetMapping("/find/xp/{id}")
    public Experience findExperience(@PathVariable Long id){
        return xpServ.findExperience(id);
    }
    
    /*Update Method (U)*/
    @PutMapping("/update/xp/{id}")
    public void updateExperience(@PathVariable Long id, @RequestBody Experience newExperience){
        /*Experience newxp = newExperience;*/
        Experience xp = xpServ.findExperience(id);
        
        xp.setTitle(newExperience.getTitle());
        xp.setCompany(newExperience.getCompany());
        xp.setFromdate(newExperience.getFromdate());
        xp.setTodate(newExperience.getTodate());
        xp.setDescription(newExperience.getDescription());
        xp.setAvatarURL(newExperience.getAvatarURL());
        
        xpServ.createExperience(xp);
    }
    
    /*@PutMapping("/update/xp/{id}")
    public void updateExperience(@PathVariable Long id,
            @RequestParam String title,
            @RequestParam String company,
            @RequestParam String fromdate,
            @RequestParam String todate,
            @RequestParam String description,
            @RequestParam String avatarURL){
        
        Experience xp = xpServ.findExperience(id);
        xp.setTitle(title);
        xp.setCompany(company);
        xp.setFromdate(fromdate);
        xp.setTodate(todate);
        xp.setDescription(description);
        xp.setAvatarURL(avatarURL);
        xpServ.createExperience(xp);
    }*/
    
    /*
    @PutMapping("/raiseID/xp/{id}")
    public void raiseExperienceID(@PathVariable Long id){
        Experience xp = xpServ.findExperience(id);
        System.out.println("id: " + id);
        id=id+10;
        System.out.println("id: " + id);
        xp.setId(id);
                
        xpServ.createExperience(xp);
    }*/
    
    /*Delete Method (D)*/
    @DeleteMapping("/delete/xp/{id}")
    public void deleteExpereince(@PathVariable Long id){
        xpServ.deleteExperience(id);
    }
}