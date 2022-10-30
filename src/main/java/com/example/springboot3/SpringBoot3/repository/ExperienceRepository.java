package com.example.springboot3.SpringBoot3.repository;

import com.example.springboot3.SpringBoot3.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository <Experience, Long>{}