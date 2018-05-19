package com.smth.services;

import com.smth.domain.Person;
import com.smth.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
