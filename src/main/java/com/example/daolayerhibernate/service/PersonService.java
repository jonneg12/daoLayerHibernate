package com.example.daolayerhibernate.service;

import com.example.daolayerhibernate.entity.City;
import com.example.daolayerhibernate.entity.MainInfo;
import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service

public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> findPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(City.valueOf(city.toUpperCase(Locale.ROOT)));
    }

    @Transactional(readOnly = true)
    public List<Person> findPersonsByAgeLessThan(int age) {
        return personRepository.findByMainInfoAgeLessThanOrderByMainInfoAgeAsc(age);
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonByNameAndSurname(String name, String surname) {
        return personRepository.findFirstByMainInfoNameAndMainInfoSurname(name, surname);
    }

    public void delete(MainInfo mainInfo) {
        personRepository.deleteById(mainInfo);
    }

    public Person createNewPerson(Person person){
        return personRepository.save(person);
    }

}
