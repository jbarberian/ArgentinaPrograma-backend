package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Project;
import com.example.springboot3.SpringBoot3.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{
    
    @Autowired
    public ProjectRepository pjRepo;
    
    @Override
    public List<Project> findAllProjects(){
        return pjRepo.findAll();
    }
    
    @Override
    public void createProject(Project pj){
        pjRepo.save(pj);
    }
    
    @Override
    public void deleteProject(Long id){
        pjRepo.deleteById(id);
    }
    
    @Override
    public Project findProject(Long id){
        return pjRepo.findById(id).orElse(null);
    } 
}
