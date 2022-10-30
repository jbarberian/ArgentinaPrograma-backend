package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Experience;
import java.util.List;

public interface IExperienceService {
    public List<Experience> findAllExperiences();
    public void createExperience(Experience xp);
    public void deleteExperience(Long id);
    public Experience findExperience(Long id);
}
