package com.smth.services;

import com.smth.converters.PersonDTOToPerson;
import com.smth.dto.PersonDTO;
import com.smth.entities.Person;
import com.smth.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Person> listAll() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person save(PersonDTO personDTO) {
        Person savedPerson = save(personDTOToPerson.convert(personDTO));
        return savedPerson;
    }
}
