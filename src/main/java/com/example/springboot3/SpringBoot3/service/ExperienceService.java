package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Experience;
import com.example.springboot3.SpringBoot3.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService{
    
    @Autowired
    public ExperienceRepository xpRepo;
    
    @Override
    public List<Experience> findAllExperiences(){
        return xpRepo.findAll();
    }
    
    @Override
    public void createExperience(Experience xp){
        xpRepo.save(xp);
    }
    
    @Override
    public void deleteExperience(Long id){
        xpRepo.deleteById(id);
    }
    
    @Override
    public Experience findExperience(Long id){
        return xpRepo.findById(id).orElse(null);
    }    
}
