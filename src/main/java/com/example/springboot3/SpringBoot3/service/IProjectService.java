package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Project;
import java.util.List;

public interface IProjectService {
    public List<Project> findAllProjects();
    public void createProject(Project pj);
    public void deleteProject(Long id);
    public Project findProject(Long id);
}
