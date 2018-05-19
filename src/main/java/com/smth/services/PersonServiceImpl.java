package com.smth.services;

import com.smth.converters.PersonFormToPerson;
import com.smth.domain.Person;
import com.smth.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;
    private PersonFormToPerson personFormToPerson;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonFormToPerson personFormToPerson) {
        this.personRepository = personRepository;
        this.personFormToPerson = personFormToPerson;
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
