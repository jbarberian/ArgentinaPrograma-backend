package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Education;
import java.util.List;

public interface IEducationService {
    public List<Education> findAllEducations();
    public void createEducation(Education ed);
    public void deleteEducation(Long id);
    public Education findEducation(Long id);
}
