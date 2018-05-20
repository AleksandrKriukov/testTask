package com.smth.services;

import com.smth.converters.PersonDTOToPerson;
import com.smth.entities.Person;
import com.smth.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;
    private PersonDTOToPerson personDTOToPerson;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonDTOToPerson personDTOToPerson) {
        this.personRepository = personRepository;
        this.personDTOToPerson = personDTOToPerson;
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
