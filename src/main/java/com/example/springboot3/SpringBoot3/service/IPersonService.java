package com.example.springboot3.SpringBoot3.service;

import com.example.springboot3.SpringBoot3.model.Person;
import java.util.List;

public interface IPersonService {
    public List<Person> findAllPeople();
    public void createPerson(Person p);
    public void deletePerson(Long id);
    public Person findPerson(Long id);
}
