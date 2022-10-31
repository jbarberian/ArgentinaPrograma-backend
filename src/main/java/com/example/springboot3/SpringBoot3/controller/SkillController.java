package com.example.springboot3.SpringBoot3.controller;

import com.example.springboot3.SpringBoot3.model.Skill;
import com.example.springboot3.SpringBoot3.service.ISkillService;
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
public class SkillController {
    
    @Autowired
    private ISkillService skServ;
    
    /*Create Method (C)*/
    @PostMapping("/new/sk")
    public void createSkill(@RequestBody Skill sk){
        skServ.createSkill(sk);
    }
        
    /*Read Method (R)*/
    @GetMapping("/findall/sk")
    @ResponseBody
    public List<Skill> findAllSkills(){
        return skServ.findAllSkills();
    }
    
    @GetMapping("/find/sk/{id}")
    public Skill findSkill(@PathVariable Long id){
        return skServ.findSkill(id);
    }
    
    /*Update Method (U)*/
    @PutMapping("/update/sk/{id}")
    public void updateEducation(@PathVariable Long id, @RequestBody Skill newSkill){
       
        Skill sk = skServ.findSkill(id);
        
        sk.setName(newSkill.getName());
        sk.setPercentage(newSkill.getPercentage());
        
        skServ.createSkill(sk);
    }
    
    /*Delete Method (D)*/
    @DeleteMapping("/delete/sk/{id}")
    public void deleteSkill(@PathVariable Long id){
        skServ.deleteSkill(id);
    }
}
