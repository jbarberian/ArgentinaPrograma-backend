package com.example.springboot3.SpringBoot3.controller;

import com.example.springboot3.SpringBoot3.model.Person;
import com.example.springboot3.SpringBoot3.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class PersonController {
    
    @Autowired
    private IPersonService pServ;

    /*Create Method (C)*/
    //@PostMapping("/new/p")
    //public String createPerson(@RequestBody Person p){
     //   p.password = HASH(p.password)
     //   pServ
    //    pServ.createPerson(p);
    //    return "New Person created successfully";
    //}
    
    /*Read Method (R)*/
    @GetMapping("/findall/p")
    @ResponseBody
    public List<Person> findAllPeople(){
        return pServ.findAllPeople();
    }
    
    @GetMapping("/find/p/{id}")
    public Person findPerson(@PathVariable Long id){
        return pServ.findPerson(id);
    }
    
    /*Update Method (U)*/
    @PutMapping("/update/p/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Person newPerson){
                            //@RequestParam String name,
                            //@RequestParam String position,
                            //@RequestParam String description,
                            //@RequestParam String avatarURL,
                            //@RequestParam String coverURL
                            //){
        
        Person p = pServ.findPerson(id);
        p.setName(newPerson.getName());
        p.setPosition(newPerson.getPosition());
        p.setDescription(newPerson.getDescription());
        p.setAvatarURL(newPerson.getAvatarURL());
        p.setCoverURL(newPerson.getCoverURL());
        
        pServ.createPerson(p);
    }
    
    /*Delete Method (D)*/
    @DeleteMapping("/delete/p/{id}")
    public String deletePerson(@PathVariable Long id){
        pServ.deletePerson(id);
        return "Person deleted successfully";
    }  
}