package com.example.springboot3.SpringBoot3.repository;

import com.example.springboot3.SpringBoot3.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository <Education, Long>{}