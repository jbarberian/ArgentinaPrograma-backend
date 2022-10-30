package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Person;
import com.example.springboot3.SpringBoot3.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService{
    
    @Autowired
    public PersonRepository pRepo;

    @Override
    public List<Person> findAllPeople() {
        return pRepo.findAll();
    }

    @Override
    public void createPerson(Person p) {
        pRepo.save(p);
    }

    @Override
    public void deletePerson(Long id) {
        pRepo.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        return pRepo.findById(id).orElse(null);
    }   
}
