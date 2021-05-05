package com.example.daolayerhibernate.repository;

import com.example.daolayerhibernate.entity.City;
import com.example.daolayerhibernate.entity.MainInfo;
import com.example.daolayerhibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, MainInfo> {


    List<Person> findByCityOfLiving(City city);

    List<Person> findByMainInfoAgeLessThanOrderByMainInfoAgeAsc(int age);

    Optional<Person> findFirstByMainInfoNameAndMainInfoSurname(String name, String surname);
}
