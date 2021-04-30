package com.example.daolayerhibernate.repository;

import com.example.daolayerhibernate.entity.City;
import com.example.daolayerhibernate.entity.MainInfo;
import com.example.daolayerhibernate.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void createRandomPersonTable(int number) {

        final List<String> names = List.of("John", "Sam", "Tim", "Wesly", "Rassel", "Mike", "Arny");
        final List<String> surnames = List.of("Smith", "Nikson", "Rider", "Washis", "Turman", "Kampbel");
        Random random = new Random();



        IntStream.range(0, number)
                .forEach(i -> {
                    final Person person = Person.builder()
                            .mainInfo(MainInfo.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(18 + random.nextInt(50))
                                    .build())
                            .cityOfLiving(City.getRandomCity(random))
                            .phoneNumber("8-9" + i + "234" + i * 2)
                            .build();

                    entityManager.persist(person);
                });
    }

    public List getPersonsByCity(String city) {
        final ArrayList<Person> people = new ArrayList<>();
        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city", Person.class);
        query.setParameter("city", City.valueOf(city.toUpperCase(Locale.ROOT)));
        return query.getResultList();
    }
}
