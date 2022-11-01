package com.example.springboot3.SpringBoot3.controller;

import com.example.springboot3.SpringBoot3.model.Project;
import com.example.springboot3.SpringBoot3.service.IProjectService;
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
public class ProjectController {
    
    @Autowired
    private IProjectService pjServ;
    
    /*Create Method (C)*/
    @PostMapping("/new/pj")
    public void createProject(@RequestBody Project pj){
        pjServ.createProject(pj);
        //return "New Project created successfully";
    }
        
    /*Read Method (R)*/
    @GetMapping("/findall/pj")
    @ResponseBody
    public List<Project> findAllProjects(){
        return pjServ.findAllProjects();
    }
    
    @GetMapping("/find/pj/{id}")
    public Project findSkill(@PathVariable Long id){
        return pjServ.findProject(id);
    }
    
    /*Update Method (U)*/
    @PutMapping("/update/pj/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project newProject
    ){
        
        Project pj = pjServ.findProject(id);
        pj.setTitle(newProject.getTitle());
        pj.setCompany(newProject.getCompany());
        pj.setDatespan(newProject.getDatespan());
        pj.setDescription(newProject.getDescription());
        pj.setAvatarURL(newProject.getAvatarURL());
        pjServ.createProject(pj);
    }
    
    /*Delete Method (D)*/
    @DeleteMapping("/delete/pj/{id}")
    public void deleteProject(@PathVariable Long id){
        pjServ.deleteProject(id);
    }
}