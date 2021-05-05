package com.example.daolayerhibernate.controller;

import com.example.daolayerhibernate.entity.City;
import com.example.daolayerhibernate.entity.MainInfo;
import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/find-by-city")
    public List<Person> findPersonsByCity(@RequestParam String city) {
        return personService.findPersonsByCity(city);
    }

    @GetMapping("/find-by-age")
    public List<Person> findPersonsByAge(@RequestParam int age) {
        return personService.findPersonsByAgeLessThan(age);
    }

    @GetMapping("/find-all")
    public List<Person> findAllPersons() {
        return personService.findAllPersons();
    }

    @GetMapping("/find-by-name-and-surname")
    public Optional<Person> findPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.findPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/delete-by-id")
    public void deleteById(@RequestParam String name, @RequestParam String surname, @RequestParam int age) {
        personService.delete(MainInfo.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .build());
    }

    @GetMapping("/create-new-person")
    public Person createNewPerson(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int age,
            @RequestParam String phone,
            @RequestParam String city) {
        return personService.createNewPerson(Person.builder()
                .mainInfo(MainInfo.builder()
                        .name(name)
                        .surname(surname)
                        .age(age)
                        .build())
                .phoneNumber(phone)
                .cityOfLiving(City.valueOf(city.toUpperCase(Locale.ROOT)))
                .build());
    }

}
