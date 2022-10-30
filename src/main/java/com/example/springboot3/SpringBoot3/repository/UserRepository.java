package com.example.springboot3.SpringBoot3.repository;

import com.example.springboot3.SpringBoot3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{ //Integer en vez de Long?
    User findByUsername(String username);
}
