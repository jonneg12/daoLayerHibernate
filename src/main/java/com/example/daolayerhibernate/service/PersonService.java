package com.example.daolayerhibernate.service;

import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }

    @Transactional
    public void createRandomPersonTable(int number) {
        personRepository.createRandomPersonTable(number);
    }
}
