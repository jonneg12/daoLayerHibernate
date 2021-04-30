package com.example.daolayerhibernate.controller;

import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/create-table")
    public void createRandomPersonTable(@RequestParam String number){
        personService.createRandomPersonTable(Integer.parseInt(number));
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city){
        return personService.getPersonsByCity(city);
    }
}
