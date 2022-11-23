package com.neutrio.peopledbweb.data;

import com.neutrio.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {

    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
//                    new Person(null, "Jake", "Snake", LocalDate.of(1950,2,1), "dummy@sample.com", new BigDecimal("5000")),
//                    new Person(null, "Sarah", "Smith", LocalDate.of(1960,5,1), "dummy@sample.com", new BigDecimal("6000") ),
//                    new Person(null, "Johny", "Jackson", LocalDate.of(1970,7,1), "dummy@sample.com", new BigDecimal("7000")),
//                    new Person(null, "Bobby", "Mark", LocalDate.of(1980,11,1), "dummy@sample.com", new BigDecimal("8000")),
//                    new Person(null, "Jerry", "McGuire", LocalDate.of(1980,1,1), "dummy@sample.com", new BigDecimal("4000")),
//                    new Person(null, "Pete", "Jane", LocalDate.of(1980,10,1), "dummy@sample.com", new BigDecimal("3000")),
//                    new Person(null, "Kenny", "Kim", LocalDate.of(1980,12,1), "dummy@sample.com", new BigDecimal("2000"))
            );

            personRepository.saveAll(people);
        }
    }
}
