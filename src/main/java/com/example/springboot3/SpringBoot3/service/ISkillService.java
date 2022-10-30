package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Skill;
import java.util.List;

public interface ISkillService {
    public List<Skill> findAllSkills();
    public void createSkill(Skill sk);
    public void deleteSkill(Long id);
    public Skill findSkill(Long id);
}
