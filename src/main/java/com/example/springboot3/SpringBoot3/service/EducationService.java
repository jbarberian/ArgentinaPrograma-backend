package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Education;
import com.example.springboot3.SpringBoot3.repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService{
    
    @Autowired
    public EducationRepository edRepo;
    
    @Override
    public List<Education> findAllEducations(){
        return edRepo.findAll();
    }
    
    @Override
    public void createEducation(Education ed){
        edRepo.save(ed);
    }
    
    @Override
    public void deleteEducation(Long id){
        edRepo.deleteById(id);
    }
    
    @Override
    public Education findEducation(Long id){
        return edRepo.findById(id).orElse(null);
    } 
}
