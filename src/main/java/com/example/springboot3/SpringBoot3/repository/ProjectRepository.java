package com.example.springboot3.SpringBoot3.repository;

import com.example.springboot3.SpringBoot3.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long>{}