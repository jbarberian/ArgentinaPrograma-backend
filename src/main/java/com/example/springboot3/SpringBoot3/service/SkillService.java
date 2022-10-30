package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Skill;
import com.example.springboot3.SpringBoot3.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    
    @Autowired
    public SkillRepository skRepo;
    
    @Override
    public List<Skill> findAllSkills(){
        return skRepo.findAll();
    }
    
    @Override
    public void createSkill(Skill sk){
        skRepo.save(sk);
    }
    
    @Override
    public void deleteSkill(Long id){
        skRepo.deleteById(id);
    }
    
    @Override
    public Skill findSkill(Long id){
        return skRepo.findById(id).orElse(null);
    } 
}
